<div class="pagehead">
  <h1>KOMA MSB</h1>
  <p>This is the code for MSB Component, This code is implemented in XMPP or MSB Server varian</p>
</div>
<table>
<tr>
<td>
<img style="padding:5px;background-color: #fff;border-radius: 5px;" src="https://user-images.githubusercontent.com/15040338/87261252-d5169700-c4df-11ea-8b65-a8a40024242b.JPG" width="75%">
</td>
</tr>
</table>
<div class="Subhead">
  <div class="Subhead-heading">Base Functions</div>
</div>
<div class="Subhead">
  <div class="Subhead-heading">Requirement</div>
  <p>1. Install MySQL Server and load file import.sql (for DB Simulation)</p>
  <p>2. Open and Build with Netbeans IDE 8.2</p>
  <p>3. Change configuration in file koma-msb/src/main/resources/application.properties for DB name</p>
  <p>4. Change configuration in file koma-msb/src/main/resources/application.properties for number of Instance</p>
  <p>5. Check & Change server.key in file koma-msb/src/main/resources/application.properties for Synch with other end point (Optional)</p>
</div>
<div class="Subhead">
  <div class="Subhead-heading">Run</div>
  <p>$java -jar koma-msb-1.0.1-RELEASE.jar<p>
</div>
# base functions
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
<br>
