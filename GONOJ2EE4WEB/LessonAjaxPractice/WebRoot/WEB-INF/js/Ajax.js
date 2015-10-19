function Ajax(config)
{
	var cfg = config || {};
	var url = cig.url;
	var method = cfg.method;
	var data = cfg.data;
	var success = cfg.success || function(){};
	var failure = cfg.failure || function(){};
	var dataStr = "";
	var async = cfg.async;
	
	var xmlHttpReq = Ajax.createXMLHttpRequest();
	prepareXMLHttpRequest(xmlHttpReq);
	
	
	function prepareXMLHttpRequest(xmlHttpReq)
	{
		var array = [];
		for(var p in data)
		{
			array.push(p + "=" + data[p]);
		}
		dataStr = array.join("&");
		if(method === "get")
		{
			url += "?" + dataStr;
			xmlHttpReq.open(method, url, asny);
			xmlHttpReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			
			xmlHttpReq.onreadystatechange = function()
			{
				if(xmlHttpReq.readyState == 4)
				{
					if(xmlHttpReq.state >= 200 && xmlHttpReq.status < 400)
					{
						success(xmlHttpReq.responseText);
					}
					else
					{
						failure(xmlHttpReq.responseText);
					}
				}
			};
		}
		
		this.send = function()
		{
			if(method === "get")
			{
				xmlHttpReq.send();
			}
			else if(method === "post")
			{
				xmlHttpReq.send(dataStr);
			}
		};		
	}	
	
	Ajax.creatXMLHttpRequest = function()
	{
		var xmlHttpReq = null;
		if(window.XMLHttpRequest)
		{
			Ajax.createXMLHttpRequest = function()
			{
				return new XMLHttpRequest();
			};
			return Ajax.createXMLHttpRequest();
		}
		else
		{
			try
			{
				xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
				Ajax.createXMLHttpRequest = function()
				{
					return new ActiveXObject("Msxml2.XMLHTTP");
				};
				return xmlHttpReq;
			}catch(e)
			{
				xmlHttpReq = new ActiveXObject("Msxm2.XMLHTTP");
				Ajax.createXMLHttpRequest = function()
				{
					return new ActiveXObject("Msxml2.XMLHTTP");
				};
				return xmlHttpReq;
			}
		}
	};
	return xmlHttpReq;
};