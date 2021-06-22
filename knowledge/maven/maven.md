
### 1.dependencyManagement和dependencies区别?
    前者用在父类管理，让子用的时候不用写版本号 因为会沿着父类往上找
    后者用在子类的依赖管理，没有指定版本号用父类的，如果不在子项目中声明依赖，是不会从父项目中继承下来的；只有子项目中写了该依赖，并且没有指定具体版本才会从父项目中继承该项，并且version和scope都读取自父pom

### 2.Unable to import maven project: See logs for details?
    xml文件，版本与idea冲突
    https://blog.csdn.net/zz18435842675/article/details/102662527/
    
    版本变更https://blog.csdn.net/weixin_43777065/article/details/111357331

   
### 3.IDEA 配置 Log4j（Maven）
    https://www.cnblogs.com/c21w/p/13334011.html
    
### 4.热部署
    https://www.cnblogs.com/xiaomaomao/p/14251443.html

### 5.热部署生效但是404问题？
    https://blog.csdn.net/weixin_44460896/article/details/109695652
    在yml文件中添加如图配置即可。
       原因：
       DevTools的检测时间和idea的编译所需时间存在差异。
       在idea还没完成编译工作前，DevTools就开始进行重启和加载，导致@RequestMapping没有被全部正常处理。故：加长devtools的轮询时间，增大等待时间。
        spring:
          devtools:
            restart:
              poll-interval: 2s
              quiet-period: 1s
   

### 6.springboot在idea的RunDashboard如何显示出来
    1. 则可以通过修改idea的workspace.xml的方式来快速打开Run Dashboard窗口
    2. 打开workspace.xml文件之后，找到component为RunDashboard的节点处，然后在component标签里添加
      <option name="configurationTypes">
            <set>
              <option value="SpringBootApplicationConfigurationType" />
            </set>
      </option>
      最后保存重新开启idea
      https://www.cnblogs.com/yang-xiansen/p/11569040.html


### 7.解决org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)问题
        dao接口与xml的文件名不一致。 
        https://blog.csdn.net/sundacheng1989/article/details/81630370
