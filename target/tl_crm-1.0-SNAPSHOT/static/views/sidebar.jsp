<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!-- START X-NAVIGATION -->
<div class="page-sidebar">
<ul class="x-navigation">
    <li class="xn-logo">
        <a href="#/app/" style="background: #875DA1;">Bulk SMS</a>
        <a href="#" class="x-navigation-control"></a>
    </li>
    <li class="xn-profile">
        <div class="profile" style="background: #FFF;">
            <img src="${pageContext.request.contextPath}/static/img/prsp_logo.png" alt="" width="100%" height="auto"/>
        </div>                                                                        
    </li>
    <li class="xn-title">Navigation</li>
    <li class="active">
        <a ui-sref="app"><span class="fa fa-desktop"></span> <span class="xn-text">Dashboard</span></a>                        
    </li>                    
    <li class="xn-openable">
        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Administration</span></a>
        <ul>
            <li><a ui-sref="app.clients"><span class="fa fa-user"></span> Clients</a></li>
            <li><a ui-sref="app.topups"><span class="fa fa-user"></span> SMS Topups</a></li>
            <li><a ui-sref="app.accountstypes"><span class="fa fa-users"></span> Accounts Types</a></li>
            <li><a ui-sref="app.accounts"><span class="fa fa-users"></span> Accounts</a></li>
            <li><a ui-sref="app.shortcodes"><span class="fa fa-users"></span> Short Codes</a></li>
            <li><a ui-sref="app.sdpservices"><span class="fa fa-users"></span> SDP Services</a></li>
            <li><a ui-sref="app.transactiontypes"><span class="fa fa-users"></span> Transaction Types</a></li>
        </ul>
    </li>
    <li class="xn-openable">
        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Manage Contacts</span></a>
        <ul>
            <li><a ui-sref="app.addressbook"><span class="fa fa-users"></span> Address Book</a></li>
            <li><a ui-sref="app.categories"><span class="fa fa-users"></span> Categories</a></li>
            <li><a ui-sref="app.contacts"><span class="fa fa-users"></span> Contacts</a></li>
        </ul>
    </li>
    <li class="xn-openable">
        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Messaging Services</span></a>
        <ul>
            <li><a ui-sref="app.sendsms"><span class="fa fa-users"></span> Send SMS</a></li>
            <li><a ui-sref="app.bulksms"><span class="fa fa-users"></span> Send Bulk SMS</a></li>
            <li><a ui-sref="app.inbox"><span class="fa fa-users"></span> Inbox</a></li>
            <li><a ui-sref="app.outbox"><span class="fa fa-users"></span> Outbox</a></li>
            <li><a ui-sref="app.uploadedfiles"><span class="fa fa-users"></span> Uploaded Files</a></li>
        </ul>
    </li>
    <li class="xn-openable">
        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Transactions</span></a>
        <ul>
            <li><a ui-sref="app.logs"><span class="fa fa-users"></span> Transaction Logs</a></li>
        </ul>
    </li>
     <li class="xn-openable">
        <a href="#"><span class="fa fa-files-o"></span> <span class="xn-text">Users Administration</span></a>
        <ul>
            <li><a ui-sref="app.users"><span class="fa fa-users"></span> Users</a></li>
            <li><a ui-sref="app.roles"><span class="fa fa-users"></span> Roles</a></li>
        </ul>
    </li>
</ul>
<!-- END X-NAVIGATION -->
</div>