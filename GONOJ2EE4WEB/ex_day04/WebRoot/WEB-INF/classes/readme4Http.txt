 让web应用被外界访问的三种方式：
   1.直接仍绕webqpp下
    2.在server.xml文件的host元素中配置<Context path="/xxx" doBase="c:\mail"/>
    3.在服务器目录\conf\atalina\localhost\新建一个xml文件，文件名就是web应用的名称
        <Context docBase="c:\mail">

细节：
缺省的web应用
配置web应用欢迎页面：web.xml文件

web应用的组织结构：
mail
        ------------html css js jsp
            WEB-INF目录
                    classer-------java程序
                    lib-------jar文件
                     web.xml

配置一个网站：
1、在硬盘上创建网站对应的目录，在目录放一个web应用---放一个web资源
2、在server.xml文件中配置一个host元素，让host元素指向网站目录
3、在windows操作系统的host文件配置网站的主机名
4、使用ie访问

加密会话：
1、使用如下命令生成服务器证书
        keytool    -genkey    -alias    tomat    -keyalg    RSA
2、在server.xml文件中配置加密连接器，并指定加密连接器从哪个密银库中获取数字证书
        <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true" 
                maxThreads = "150" scheme="https" secure="true" clientAuth="false" sslProtocol="TLS"
                  keystoreFile="conf\.keystore" keystorePass="123456"/>    
3、使用浏览器访问：https://localhost:8443


请求头：
accept：浏览器通过这个头告诉服务器，他说支持的数据类型
Accept-Charset：浏览器通过这个头告诉服务器，它支持那种字符集
Accept-Encoding:浏览器通过这个头告诉服务器，支持的压缩格式
Accept-Language：浏览器通过这个头告诉服务器，它的语言环境
Host：浏览器通过这个头告诉服务器，想访问哪台主机
If-Modified-Since：浏览器通过这个头告诉服务器，缓存数据的时间
Refresh：浏览器通过这个头告诉服务器，客户机是哪个页面来的，    防盗链
Connection：浏览器通过这个头告诉服务器，请求完后是断开链接还是维持链接

响应头：
Location：服务器通过这个头，来告诉浏览器跳到哪里
Server：服务器通过这个头，告诉浏览器服务器的型号
Content-Encoding：服务器通过这个头，告诉浏览器，数据压缩格式
Content-Length：服务器通过这个头，告诉浏览器回送数据的长度
Content-Type：服务器通过这个头，告诉浏览器回送数据的类型
Refresh：服务器通过这个头，告诉浏览器定时刷新
Content-Disposition：服务器通过这个头，告诉浏览器以下载方式打数据
Transfer-Encoding：服务器通过这个头，告诉浏览器数据是以分块方式回送的
Expires：-1     控制浏览器不要缓存
Cache-Control：no-cache
Pragma:no-cache
