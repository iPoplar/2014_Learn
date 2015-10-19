function Ajax(config){
	var cfg = config || {};
	var url = cfg.url;
	var method = cfg.method;
	var data = cfg.data;
	var success = cfg.success || function(){
	};
	var failure = cfg.failure || function(){
		
	};
	var dataStr = "";
	var async = typeof cfg.async !== "boolean" ? true : cfg.async;
	
	var xmlHttpReq = Ajax.createXMLHttpReqeust();
	prepareXMLHttpRequest(xmlHttpReq);
	
	function prepareXMLHttpRequest(xmlHttpReq){
		var array = [];
		for(var p in data){
			array.push(p + "=" + data[p]);
		}
		dataStr = array.join("&");
		if(method === "get")
			url += "?" + dataStr;
		xmlHttpReq.open(method, url, async);
		xmlHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		
		xmlHttpReq.onreadystatechange = function(){
			if(xmlHttpReq.readyState == 4){
				if(xmlHttpReq.status >= 200 && xmlHttpReq.status < 400){
					success(xmlHttpReq.responseText);
				}else{
					failure(xmlHttpReq.responseText);
				}
			}
		};
	}
	
	this.send = function(){
		if(method === "get")
			xmlHttpReq.send();
		else if(method === "post")
			xmlHttpReq.send(dataStr);
	};
};

Ajax.createXMLHttpReqeust = function(){
	var xmlHttpReq = null;
	if(window.XMLHttpRequest){
		Ajax.createXMLHttpReqeust = function(){
			return new XMLHttpRequest();
		};
		return Ajax.createXMLHttpReqeust();
	}else{
		try{
			xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			Ajax.createXMLHttpReqeust = function(){
				return new ActiveXObject("Microsoft.XMLHTTP");
			};
			return xmlHttpReq;
		}catch(e){
			xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
			Ajax.createXMLHttpReqeust = function(){
				return new ActiveXObject("Msxml2.XMLHTTP");
			};
			return xmlHttpReq;
		}
	}
	return xmlHttpReq;
};

