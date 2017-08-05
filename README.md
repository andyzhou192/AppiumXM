# AppiumXM
AppiumXM自动化测试框架基于 Appium + testNG + maven 二次封装，采用java语言进行开发，适用于Android、iOS自动化测试，采用Excel关键字驱动实现无需编写代码即可进行自动化测试，支持jenkins持续集成，支持Android/iOS在真机或模拟器进行自动化测试，支持H5、Hybrid 、Native测试

# 环境要求
全部用最新的

# demo
**测试用例**

用例ID | 类型 | 用例描述 | CaseName | 步骤描述 | 是否执行
-----|------|---- | ----|------|----
1| APP	| 测试iOS App（QQ邮箱）		|iOSApp		|普通操作	|	YES

# 如何运行？
1、Devices文件夹下添加相应的设备信息<p>
2、testcase文件夹下编辑测试步骤流程<p>
3、支持操作：看源码。。。<p>
4、安装testng插件运行StartTest.xml或定位到工程目录下运行mvn test，ant编译中文会乱码不建议<p>
5、多设备参照StartTest.xml注释<p>
6、持续集成，Jenkins + mvn 亲测运行完美<p>
7、iOS真机需自行前往 /usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/WebDriverAgent 对 WebDriverAgent.xcodeproj 进行重签名（个人证书即可）

