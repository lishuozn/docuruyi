# docuruyi_branch_yelihu

> @author：叶李虎
>
> 2019年08月05日


------


## 基于Pdf.js实现预览功能文档
> 采用火狐pdf.js实现
>
> 官网：http://mozilla.github.io/pdf.js/
>
> 下载链接：https://github.com/mozilla/pdf.js/releases/download/v2.1.266/pdfjs-2.1.266-dist.zip



### 导入文件和使用碎片

将上面链接的文件下载并复制在

`/resources/static/ajax/libs/pdfjs-2.1.266-dist`

要引入的js和css文件。已经在`templates/include.html`中引入

```html
<!-- pdf.js插件 -->
<div th:fragment="pdf-js">
   <link rel="stylesheet" th:href="@{/ajax/libs/pdfjs-2.1.266-dist/web/viewer.css}">
   <link rel="resource" type="application/l10n" th:href="@{/ajax/libs/pdfjs-2.1.266-dist/web/locale/locale.properties}">
   <script src="../build/pdf.js" th:src="@{/ajax/libs/pdfjs-2.1.266-dist/build/pdf.js}"></script>
   <script src="../build/pdf.js" th:src="@{/ajax/libs/pdfjs-2.1.266-dist/build/pdf.worker.js}"></script>
   <script src="viewer.js" th:src="@{/ajax/libs/pdfjs-2.1.266-dist/web/viewer.js}" ></script>
</div>
```

### 使用html页面或定制 

**注意，默认pdf默认的展示页面为pdfViewer.html，在templates文件夹下**

**如果想要定制界面的话，记得在你定制的html文件上加上如下代码引入thymeleaf的代码片段**

```html
<th:block th:include="include :: pdf-js" /> 
```


### 创建并调用一个弹框
#### 准备js代码

先在前端页面上准备这样一个按钮，下面是在ruoyi生成的表格项上的代码：
加入：`actions.push('<a class="btn btn-success btn-xs" onclick="$.operate.pdfPreview()"><i class="fa fa-file-pdf-o"></i> 预览</a> ');`
即可
```html
{
 field : 'attachFile',
 title : '附件',
 formatter: function(value, row, index) {
    var actions = [];
    actions.push('<a class="btn btn-success btn-xs" onclick="$.operate.pdfPreview()"><i class="fa fa-file-pdf-o"></i> 预览</a> ');
    actions.push('<a class="btn btn-primary btn-xs" href="javascript:void(0)" onclick=""><i class="fa fa-download"></i> 下载</a> ');
    return actions.join('');
 }
},
```

#### 封装$.operate.pdfPreview()

`ry-ui.js`的源码已经被我修改，添加了封装的方法`pdfPreview.`

`在我们的页面上只要`$.operate.pdfPreview()`调用即可，这里你可以自定义传入参数`url`**(文件上传到后台的相对路径)**

还可以自己调用ajax获取后台的某个pdf文件的相对路径，然后在下面使用拼接字符串的方式创建弹框来预览pdf文件。

```
pdfPreview: function() {
          //Your ajax
          
          if($.common.isNotEmpty(url)){
      $.modal.open("文件预览", ctx + "system/pdf/pdfViewer?file="+url,900,540);
   }
          
},
```

新的界面打开的url是`localhost:system/pdf/pdfViewer?file=文件相对地址/文件名.pdf`

#### controller方法

system/pdf走的是后台`PdfViewerController`的方法

```java
@GetMapping("/pdfViewer")
public String viewPdfByPath(HttpServletRequest request)
{
    return "/pdfViewer";
}
```

这里不建议改动。
### PS

------

如果你想使用这个js插件在你的项目上，这里有个要点。

记得把`viewer.js`文件`5127`行的代码 `value`属性里面的值清空，这样就不会显示它自带的pdf文件了，如下：

```javascript
defaultUrl: { 
  value: '',
  kind: OptionKind.VIEWER
},
```
------
