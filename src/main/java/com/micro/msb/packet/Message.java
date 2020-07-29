/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micro.msb.packet;

/**
 *
 * @author SENOPATI
 */
public class Message {

    private X x;
    private State active;
    private State composing;
    private State paused;
    private State gone;
    private State offilne;
    private String thread;
    private Attr attr;
    private String body;

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public State getActive() {
        return active;
    }

    public void setActive(State active) {
        this.active = active;
    }

    public State getComposing() {
        return composing;
    }

    public void setComposing(State composing) {
        this.composing = composing;
    }

    public State getPaused() {
        return paused;
    }

    public void setPaused(State paused) {
        this.paused = paused;
    }

    public State getGone() {
        return gone;
    }

    public void setGone(State gone) {
        this.gone = gone;
    }

    public State getOffilne() {
        return offilne;
    }

    public void setOffilne(State offilne) {
        this.offilne = offilne;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getState(){
        if(this.active!=null) return "active";
        else if(this.composing!=null) return "composing";
        else if(this.paused!=null) return "paused";
        else if(this.gone!=null) return "gone";
        else if(this.offilne!=null) return "offline";
        else return "deactive";
    }
    
    @Override
    public String toString() {
        return "ClassPojo [x = " + x + ", active = " + active + ", thread = " + thread + ", attr = " + attr + ", body = " + body + "]";
    }
}
