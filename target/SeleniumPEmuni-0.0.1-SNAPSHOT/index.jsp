<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<html>
	<head>
		<title>Test Report</title>
		<link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600' rel='stylesheet' type='text/css' />
		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" />
		<link href='http://cdn.rawgit.com/noelboss/featherlight/1.0.4/release/featherlight.min.css' type='text/css' rel='stylesheet' />
		<style type='text/css'>
			html {overflow-y: scroll;}
			body {color: #022b37;font-family: 'Source Sans Pro', Calibri;font-size: 16px;margin: 0;}
			a {color: #1366d7;text-decoration: none;}
			pre {background: none repeat scroll 0 0 #f5f6f8;color: #222;font-family: Consolas;font-size: 13px;margin: 5px 0;padding: 7px 10px;white-space: pre-wrap;}
			#extent-container, #header, #dashboard, #filters, #content, #footer {width: 100%;}
			.topbar, .title, .menu, .dashboard, .filters, .content, .footer {margin: 0 auto;width: 1050px;}
			#topbar {border-bottom: 1px solid #dbdbdb;min-height: 35px;}
			.topbar {font-size: 11px;padding: 8px 0;}
			.topbar-items-left {color: #bbb;display: none;float: left;font-size: 12px;}
			.topbar-items-right {float: right;}
			.topbar-items-right span {border-left: 1px solid #ccc;padding: 0px 8px;vertical-align: sub;} .topbar-items-right span:first-child {border-left: none;}
			.headline {font-size: 12px;}
			#title {margin: 25px 0 35px;}
			.logo {color: #bbb; font-family: 'Source Sans Pro', Verdana;font-size: 16px;letter-spacing: 1px;}
			.menu-items {margin-top: -32px;float: right;}
			.menu ul li {display: inline;list-style-image: none;list-style-position: outside;padding: 10px 8px;}			
			.menu span {cursor: pointer;}
			.menu-item-selected span {color: #1366d7;}
			#dashboard {background-color: #f9f9f9;border-bottom: 1px solid #dbdbdb;max-height: 320px !important;height: 320px !important;margin-top: 20px;}
			.dashboard {padding: 40px 0;}
			#tabs-2, #tabs-3 {display: none;}
			.graphs {margin-left: auto;margin-right: auto;text-align: center;}
			.graphs div {display: inline-block;margin-bottom: -40px;}
			.summary-items {margin: 0 auto 20px;width: 1000px;}
			.summary-item {border: 1px solid #b4bfc3;display: inline-block;margin: 10px;padding: 15px 0 30px;position: relative;text-align: center;width: 220px;}
			.summary-item span {display: block;}
			.item-value {color: #393939;font-size: 24px;line-height: 40px;}
			.item-name {color: #022b36;font-size: 13px;}
			.filters {margin: 60px auto 5px !important;}
			.by-status {margin-right: 40px;}
			.by-status, .by-feature {display: inline-block;}
			.by-status div {margin-right: 2px;}
			.content {margin: 0 auto 100px !important;}
			.test {border: 1px solid #b4bfc3;color: #1366d7;cursor: pointer;height: auto;margin: 5px 0;padding: 20px;}
			.test-expanded {border: 1px solid #434e52;border-top: 2px solid #434e52;height: auto;width: auto;}
			.name {font-size: 19px;}
			.test-info {float: right;margin-top: -20px;text-transform: uppercase;}
			.test-status, .startedAt, .endedAt {font-family: Verdana, "Lucida Grande";font-size: 11px;padding: 6px 10px;}
			.startedAt i, .endedAt i {padding-right: 5px;}
			.startedAt i {color:#5cb85c;}
			.endedAt i {color:#d9534f;}
			.test-status {color: #fff !important;}
			.startedAt, .endedAt {border: 1px solid #507fd6;color: #121212;}
			.description {color: #444;margin-top: 15px;padding:2px;}
			.description-title {font-size: 13px;font-weight: 600;text-transform: uppercase;}
			.description-content {}
			.test-header {margin: -20px;padding: 20px;}
			.exec-info {display: none;margin-top: 25px;}
			.extent-table {border: 1px solid #ddd;border-collapse: collapse;color: #222;width: 100%;}
			.extent-table tr:hover {background-color: #f9fafc;}
			.extent-table th {background: #f5f6f8;border-bottom: 1px solid #ddd;color: #242533;font-size: 12px;font-weight: 600;padding: 12px 10px;text-align: left;text-transform: uppercase;}
			.extent-table td {padding: 7px 10px;border-bottom: 1px solid #e9e9e9;word-break: break-all;}
			.extent-table td:first-child {width: 67px;}
			.extent-table td:nth-child(2) {text-align: left !important;width: 45px;}
			.extent-table td.status > i {padding-left: 10px;}
			.log-event {font-family: monospace, Consolas;font-size: 13px !important;}
			.logevent-timestamp {font-weight: bold;}
			.extent-button {border: 1px solid;cursor: pointer;display: inline;font-size: 13px;text-decoration: none;line-height: 13.4667px;padding: 6px 18px;text-align: center;transition: all 0.2s ease-in-out 0s;vertical-align: middle;}
			.extent-button i {padding-right: 5px;}
			.extent-button-green {border-color: #5cb85c;color: #5cb85c;}
			.extent-button-green:hover {background-color: #5cb85c;color: white;}
			.extent-button-red {border-color: #d9534f;color: #d9534f;}
			.extent-button-red:hover {background-color: #d9534f;color: white;}
			.extent-button-orange {border-color: #f0ad4e;color: #f0ad4e;}
			.extent-button-orange:hover {background-color: #f0ad4e;color: white;}
			.extent-button-lightred {border-color: #e67672;color: #e67672;}
			.extent-button-lightred:hover {background-color: #e67672;color: white;}
			.status {border-radius: 3px; font-family: 'Source Sans Pro';font-size: 12px;padding: 4px 6px; text-align: center;}
			.status.fail, .status.fail i {color: #eb4549;} .test-info .fail{background-color: #eb4549 !important;}
			.status.fatal, .status.fatal i {color: darkred;} .test-info .fatal{background-color: darkred !important;}
			.status.error, .status.error i {color: tomato;} .test-info .error {background-color: tomato !important;}
			.status.warning, .status.warning i {color: orange;} .test-info .warning {background-color: orange !important;}
			.status.pass, .status.pass i {color: #32CD32;} .test-info .pass {background-color: #32CD32 !important;}
			.status.info, .status.info i {color: #22a1c4;}
			.status.skip, .status.skip i {color: #999;} .test-info .skip {background-color: #999 !important;}
			.extent-button .fa, .status .fa {font-size: 13px !important;}
			#footer {padding: 20px 0 100px;}
			.report-img {border: 4px solid #eee;display: block;height: auto;margin-left: 5px;margin-top: 15px;text-align: center;width: 50%;}
			.report-img-large {border: 4px solid #eee;display: block;height: auto;margin-left: auto;margin-right: auto;margin-top: 15px;text-align: center;width: 60%;}
			.pointer {cursor: pointer;}
			.unselected i{color:#aaa !important;}
			/* labels */			
			.label {border-radius: 4px; color: #fff; font-size: 14px; padding: 0 6px; }
			.label.success {background-color: #7fbb00; }
			.label.failure {background-color: #dc5034; }
			.label.warn {background-color: #fdba5b; }
			.label.info {background-color: #55bad8;}
			/*!
			 * Bootstrap v3.3.2 (http://getbootstrap.com)
			 * Copyright 2011-2015 Twitter, Inc.
			 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
			 */
			.btn {display: inline-block;margin-bottom: 0;font-weight: normal;text-align: center;vertical-align: middle;-ms-touch-action: manipulation;touch-action: manipulation;cursor: pointer;background-image: none;white-space: nowrap;padding: 6px 12px;font-size: 14px;line-height: 1.42857143;-webkit-user-select: none;-moz-user-select: none;-ms-user-select: none;user-select: none;}
			.btn:focus,.btn:active:focus,.btn.active:focus,.btn.focus,.btn:active.focus,.btn.active.focus {outline: thin dotted;outline: 5px auto -webkit-focus-ring-color;outline-offset: -2px;}
			.btn:hover,.btn:focus,.btn.focus {color: #222;text-decoration: none;}
			.btn-default {color: #222;}
			.btn-default:hover,.btn-default:focus,.btn-default.focus,.btn-default:active,.btn-default.active,.open > .dropdown-toggle.btn-default {color: #333333;background-color: #e6e6e6;border-color: #adadad;}
			.caret {display: inline-block;width: 0;height: 0;margin-left: 2px;vertical-align: middle;border-top: 4px solid;border-right: 4px solid transparent;border-left: 4px solid transparent;}
			.dropup,.dropdown {position: relative;}
			.dropdown-toggle:focus {outline: 0;}
			.dropdown-menu {position: absolute;top: 100%;left: 0;z-index: 1000;display: none;float: left;min-width: 160px;padding: 5px 0;margin: 2px 0 0;list-style: none;font-size: 14px;text-align: left;background-color: #ffffff;border: 1px solid #cccccc;border: 1px solid rgba(0, 0, 0, 0.15);border-radius: 4px;-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);box-shadow: 0 6px 12px rgba(0, 0, 0, 0.175);-webkit-background-clip: padding-box;background-clip: padding-box;}
			.dropdown-menu.pull-right {right: 0;left: auto;}
			.dropdown-menu .divider {height: 1px;margin: 9px 0;overflow: hidden;background-color: #e5e5e5;}
			.dropdown-menu > li > a {display: block;padding: 3px 20px;clear: both;font-weight: normal;line-height: 1.42857143;color: #333333;white-space: nowrap;}
			.dropdown-menu > li > a:hover,.dropdown-menu > li > a:focus {text-decoration: none;color: #262626;background-color: #f5f5f5;}
			.dropdown-menu > .active > a,.dropdown-menu > .active > a:hover,.dropdown-menu > .active > a:focus {color: #ffffff;text-decoration: none;outline: 0;background-color: #337ab7;}
			.dropdown-menu > .disabled > a,.dropdown-menu > .disabled > a:hover,.dropdown-menu > .disabled > a:focus {color: #777777;}
			.dropdown-menu > .disabled > a:hover,.dropdown-menu > .disabled > a:focus {text-decoration: none;background-color: transparent;background-image: none;filter: progid:DXImageTransform.Microsoft.gradient(enabled = false);cursor: not-allowed;}
			.open > .dropdown-menu {display: block;}
			.open > a {outline: 0;}
			.dropdown-menu-right {left: auto;right: 0;}
			.dropdown-menu-left {left: 0;right: auto;}
			.btn-group,.btn-group-vertical {position: relative;display: inline-block;vertical-align: middle;}
			.btn-group > .btn,.btn-group-vertical > .btn {position: relative; float: left;}
			.btn-group > .btn:hover,.btn-group-vertical > .btn:hover,.btn-group > .btn:focus,.btn-group-vertical > .btn:focus,.btn-group > .btn:active,.btn-group-vertical > .btn:active,.btn-group > .btn.active,.btn-group-vertical > .btn.active {z-index: 2;}
			.btn-group .btn + .btn,.btn-group .btn + .btn-group,.btn-group .btn-group + .btn,.btn-group .btn-group + .btn-group {margin-left: -1px;}
			.dropdown-menu i { font-size: 11px; padding-right: 10px; }
			.dropdown-menu div { display: inline-block; width: 24px !important; }
			.btn-group > .btn:first-child:not(:last-child):not(.dropdown-toggle) {background-color:#f1f5f8; border: medium none; border-bottom-right-radius: 0; border-top-right-radius: 0; font-family: 'Source Sans Pro';font-size:13px;padding: 11px 22px; }
		</style>
		<style type='text/css'>.topbar-items-left { display: inline-block; }</style><!--%%CUSTOMCSS%%-->
	</head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.js"></script>
<body id='dashboard' class='dashboard'>


	<div id='extent-container'>
			<div id='header'>
				<div id='topbar'>
					<div class='topbar'>
						<div class='topbar-items'>
							<div class='topbar-items-left'>
								extent-reports
							</div>
							<div class='topbar-items-right'>
								<span class='headline'><!--%%REPORTSUMMARY%%-->AVIZVA - Test Automation Report<!--%%REPORTSUMMARY%%--></span>
								<span class='pointer resize expand' title='Resize view by enlarging/compressing tests area. Use this option if you have long test logs and would like to use broader viewing angles for analysis.'><i class='fa fa-expand'></i></span>	
								<span class='pointer toggle-type' title='Convert Tests-toggles into accordion so only one test can remain open at a time. Turning this open will enable viewing only one test at a time and will close all others for a clean and organized view. Use this open if you intend to analyse only one test at a time.'><i class='fa fa-toggle-off'></i></span>	
								<span class='pointer expand-tests' title='Expand all tests to view their results. Note: this control only expands tests if the accordion-toggle is not enabled.'><i class='fa fa-bars'></i></span>
								<span class='pointer collapse-tests' title='Collapse all tests.'><i class='fa fa-cube'></i></span>
							</div>
						</div>
					</div>
				</div>
				<div id='title'>
					<div class='title'>
						<div class='logo'><!--%%LOGO%%-->Smoke Test Report<!--%%LOGO%%--></div>
					</div>
					<div class='menu'>
						<div class='menu-items'>
							<ul>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div id='dashboard'>
				<div class='dashboard'>
					<div id='tabs-1'>
						<div class='graphs'>
							<div id='ts-status-dashboard'></div>
							<div id='step-status-dashboard'></div>
						</div>
					</div>
<script>
$(document).ready(function(){
	if($(".message").val()!="")
		{
		window.location.replace($(".burl").val());
		window.location.href($(".burl").val());
		window.reload($(".burl").val());
		}
	
});
</script>

<h1 align="center">PE Automation test</h1>
<form method="post" action="testmodule" align="center">
Test module:  <select name="module" align="center" width="200px">
  <option value="quotehome">Create PE</option>
  <option value="createpe">Quote Home</option>
</select>
<input type="submit" value="Read Test Cases"/>
</form>
<br>
<br>
<br>

	
	<form action="testdata" id="testdata">
	<table align="center" border="0">
	<tr>
		
</table>
<table class="testCaseTable" border="1 px" align="center" cellpadding="3px">

	<c:set var="count" value="0"/>
	<c:forEach items="${testcases}" begin="1" var="row">
	
	<tr class="testCases">
	<c:set var="count" value="${count+1}"/>
	<c:forEach items="${row}" var="cell">
	<td class="testCase__content" width="300px" align="center">${cell}</td>
	</c:forEach>
	<td class="testCase__radioButton" align="center">
  			<input type="radio" name="${count}" value="Y" width="100px" align="center" checked="checked" > Yes
  			<input type="radio" name="${count}" value="N" width="100px" align="center"> No
    </td>
  
	</tr>
	</c:forEach>
	
</table>
<br>
<br>
<center>${message}
</form>
 <c:forEach var="testresult" items="${testresults}">
 ${testresult}<br>
 </c:forEach>
${test}
</center>


<input class="message" type="hidden" value="${message}"/>  
<input class="burl" type="hidden" value="${redirectURL}"/> 
</form>



<script>
$(document).ready(function() {
    $("#testrun").submit(function(e) {
        $("#table-head").hide();
    });
});</script>
</body>
</html>