package com.micro.msb.util;

public class SASLMechanism {

    private static final String INITAL_NONCE = "00000001";
    private static final String QOP_VALUE = "auth";
    private static final String PROTOCOL = "xmpp";

    public SASLMechanism() {
    }

    public String getKeyValue(byte[] response, String keyRef) throws Exception {

        String challengeString = new String(response, "UTF-8");
        String[] challengeParts = challengeString.split(",");
        for (String part : challengeParts) {
            int pos = part.indexOf("=");
            String key = part.substring(0,pos).trim();
            String value = part.substring(pos+1).replace("\"", "").trim();
            if(key.equalsIgnoreCase(keyRef)) return value;
        }
        return null;
    }

    public byte[] getChallenge(String realm) {
        String nonce = StringUtils.randomString(40);
        StringBuilder data = new StringBuilder();
        data.append("realm=\"").append(realm).append("\",");
        data.append("nonce=\"").append(nonce).append("\",");
        data.append("qop=\"auth\",");
        data.append("charset=utf-8,");
        data.append("algorithm=md5-sess");
        return data.toString().getBytes();
    }

    public byte[] getChallenge(String realm,String algorithm) {
        String nonce = StringUtils.randomString(40);
        StringBuilder data = new StringBuilder();
        data.append("realm=\"").append(realm).append("\",");
        data.append("nonce=\"").append(nonce).append("\",");
        data.append("qop=\"auth\",");
        data.append("charset=utf-8,");
        data.append("algorithm=").append(algorithm);
        return data.toString().getBytes();
    }
    
    public byte[] evaluateChallenge(byte[] challenge,String user,String password,String domain) throws Exception {

        String realm = domain;
        String nonce = getKeyValue(challenge, "nonce");
        String cnonce = StringUtils.randomString(40);
        String authzid = user;
        String digestUri = PROTOCOL + "/" + domain;

        String responseValue = calcResponse(user, realm, password, nonce, INITAL_NONCE, cnonce, authzid, digestUri);
        String saslString = createResponse(user, realm, nonce, cnonce, digestUri, responseValue, authzid);
        byte[] response = StringUtils.toBytes(saslString);

        return response;
    }

    private String calcResponse(String user, String realm, String password, String nonce, String ncvalue, String cnonce, String authzid, String digestUri) {

        byte[] A1;

        if (authzid != null) {
            A1 = concact(MD5.bytes(user + ':' + realm + ':' + password), StringUtils.toBytes(':' + nonce + ':' + cnonce + ':' + authzid));
        } else {
            A1 = concact(MD5.bytes(user + ':' + realm + ':' + password), StringUtils.toBytes(':' + nonce + ':' + cnonce));
        }
            
        String hex_hashed_a1 = MD5.hex(A1);

        StringBuilder A2 = new StringBuilder();
        A2.append("AUTHENTICATE");
        A2.append(':');
        A2.append(digestUri);
        String hex_hashed_a2 = MD5.hex(A2.toString());

        StringBuilder kd_argument = new StringBuilder();
        kd_argument.append(hex_hashed_a1);
        kd_argument.append(RFC3261.FIELD_NAME_SEPARATOR);
        kd_argument.append(nonce);
        kd_argument.append(RFC3261.FIELD_NAME_SEPARATOR);
        kd_argument.append(ncvalue);
        kd_argument.append(RFC3261.FIELD_NAME_SEPARATOR);
        kd_argument.append(cnonce);
        kd_argument.append(RFC3261.FIELD_NAME_SEPARATOR);
        kd_argument.append(QOP_VALUE);
        kd_argument.append(RFC3261.FIELD_NAME_SEPARATOR);
        kd_argument.append(hex_hashed_a2);

        String responseValue = MD5.hex(kd_argument.toString());
        return responseValue;
    }

    public String calcResponse(byte[] response, String password) throws Exception {

        String user = getKeyValue(response, "username");
        String realm = getKeyValue(response, "realm");
        String nonce = getKeyValue(response, "nonce");
        String ncvalue = getKeyValue(response, "nc");
        String cnonce = getKeyValue(response, "cnonce");
        String digestUri = getKeyValue(response, "digest-uri");
        String authzid = getKeyValue(response, "authzid");

        String responseValue = calcResponse(user, realm, password, nonce, ncvalue, cnonce, authzid, digestUri);
        return responseValue;
    }

    private String createResponse(String user, String realm, String nonce, String cnonce, String digestUri, String responseValue, String authzid) {
        StringBuilder a1 = new StringBuilder();
        a1.append("charset=utf-8");
        a1.append(",username=\"").append(user).append('"');
        a1.append(",realm=\"").append(realm).append('"');
        a1.append(",nonce=\"").append(nonce).append('"');
        a1.append(",nc=00000001");
        a1.append(",cnonce=\"").append(cnonce).append('"');
        a1.append(",digest-uri=\"").append(digestUri).append('"');
        a1.append(",maxbuf=65536");
        a1.append(",response=").append(responseValue);
        a1.append(",qop=auth");
        a1.append(",authzid=\"").append(authzid).append('"');
        return a1.toString();
    }

    private byte[] concact(byte[] arrayOne, byte[] arrayTwo) {
        int combinedLength = arrayOne.length + arrayTwo.length;
        byte[] res = new byte[combinedLength];
        System.arraycopy(arrayOne, 0, res, 0, arrayOne.length);
        System.arraycopy(arrayTwo, 0, res, arrayOne.length, arrayTwo.length);
        return res;
    }

    public String createRspAuth(byte[] response, String password) throws Exception {

        String user = getKeyValue(response, "username");
        String realm = getKeyValue(response, "realm");
        String nonce = getKeyValue(response, "nonce");
        String ncvalue = getKeyValue(response, "nc");
        String cnonce = getKeyValue(response, "cnonce");
        String digestUri = getKeyValue(response, "digest-uri");
        String authzid = getKeyValue(response, "authzid");

        byte[] A1;

        if (authzid != null) {
            A1 = concact(MD5.bytes(user + ':' + realm + ':' + password), StringUtils.toBytes(':' + nonce + ':' + cnonce + ':' + authzid));
        } else {
            A1 = concact(MD5.bytes(user + ':' + realm + ':' + password), StringUtils.toBytes(':' + nonce + ':' + cnonce));
        }
        String hex_hashed_a1 = MD5.hex(A1);

        StringBuilder A2 = new StringBuilder();
        A2.append(':');
        A2.append(digestUri);
        String hex_hashed_a2 = MD5.hex(A2.toString());

        StringBuilder kd_argument = new StringBuilder();
        kd_argument.append(hex_hashed_a1);
        kd_argument.append(':');
        kd_argument.append(nonce);
        kd_argument.append(':');
        kd_argument.append(ncvalue);
        kd_argument.append(':');
        kd_argument.append(cnonce);
        kd_argument.append(':');
        kd_argument.append(QOP_VALUE);
        kd_argument.append(':');
        kd_argument.append(hex_hashed_a2);

        String responseValue = MD5.hex(kd_argument.toString());
        return responseValue;
    }
}
