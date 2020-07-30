# koma-msb
This is the code for MSB Component, This code is implemented in XMPP or MSB Server varian <br>
<table>
<tr>
<td>
<img style="padding:5px;background-color: #fff;border-radius: 5px;" src="https://user-images.githubusercontent.com/15040338/87261252-d5169700-c4df-11ea-8b65-a8a40024242b.JPG" width="75%">
</td>
</tr>
</table>
## base functions
- Reistration
- Authentication
- Roster & Subscription
- Presence
- Message
- vCard
- Disco Item
- Disco Info
- Offline Message
- Proxy & Forward (Optional for MSB)
## requirement
1. Install MySQL Server and load file import.sql (for DB Simulation) <br/>
2. Open and Build with Netbeans IDE 8.2 <br/>
3. Change configuration in file koma-msb/src/main/resources/application.properties for DB name <br/>
4. Change configuration in file koma-msb/src/main/resources/application.properties for number of Instance <br/>
5. Check & Change server.key in file koma-msb/src/main/resources/application.properties for Synch with other end point (Optional) <br/>
## run
$java -jar koma-msb-1.0.1-RELEASE.jar <br/>
