 ��webӦ�ñ������ʵ����ַ�ʽ��
   1.ֱ������webqpp��
    2.��server.xml�ļ���hostԪ��������<Context path="/xxx" doBase="c:\mail"/>
    3.�ڷ�����Ŀ¼\conf\atalina\localhost\�½�һ��xml�ļ����ļ�������webӦ�õ�����
        <Context docBase="c:\mail">

ϸ�ڣ�
ȱʡ��webӦ��
����webӦ�û�ӭҳ�棺web.xml�ļ�

webӦ�õ���֯�ṹ��
mail
        ------------html css js jsp
            WEB-INFĿ¼
                    classer-------java����
                    lib-------jar�ļ�
                     web.xml

����һ����վ��
1����Ӳ���ϴ�����վ��Ӧ��Ŀ¼����Ŀ¼��һ��webӦ��---��һ��web��Դ
2����server.xml�ļ�������һ��hostԪ�أ���hostԪ��ָ����վĿ¼
3����windows����ϵͳ��host�ļ�������վ��������
4��ʹ��ie����

���ܻỰ��
1��ʹ�������������ɷ�����֤��
        keytool    -genkey    -alias    tomat    -keyalg    RSA
2����server.xml�ļ������ü�������������ָ���������������ĸ��������л�ȡ����֤��
        <Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true" 
                maxThreads = "150" scheme="https" secure="true" clientAuth="false" sslProtocol="TLS"
                  keystoreFile="conf\.keystore" keystorePass="123456"/>    
3��ʹ����������ʣ�https://localhost:8443


����ͷ��
accept�������ͨ�����ͷ���߷���������˵֧�ֵ���������
Accept-Charset�������ͨ�����ͷ���߷���������֧�������ַ���
Accept-Encoding:�����ͨ�����ͷ���߷�������֧�ֵ�ѹ����ʽ
Accept-Language�������ͨ�����ͷ���߷��������������Ի���
Host�������ͨ�����ͷ���߷��������������̨����
If-Modified-Since�������ͨ�����ͷ���߷��������������ݵ�ʱ��
Refresh�������ͨ�����ͷ���߷��������ͻ������ĸ�ҳ�����ģ�    ������
Connection�������ͨ�����ͷ���߷���������������ǶϿ����ӻ���ά������

��Ӧͷ��
Location��������ͨ�����ͷ���������������������
Server��������ͨ�����ͷ��������������������ͺ�
Content-Encoding��������ͨ�����ͷ�����������������ѹ����ʽ
Content-Length��������ͨ�����ͷ������������������ݵĳ���
Content-Type��������ͨ�����ͷ������������������ݵ�����
Refresh��������ͨ�����ͷ�������������ʱˢ��
Content-Disposition��������ͨ�����ͷ����������������ط�ʽ������
Transfer-Encoding��������ͨ�����ͷ������������������Էֿ鷽ʽ���͵�
Expires��-1     �����������Ҫ����
Cache-Control��no-cache
Pragma:no-cache
