package com.ruoyi.project.system.pdfViewer;
import com.ruoyi.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * 功能描述: 打开一个pdf文件
 * 在前端使用$.modal.open("", ctx + "system/pdf"+"/pdfViewer?file="+"文件相对路径");
 * 比如在/static/下的 /pdf/compressed.tracemonkey-pldi-09.pdf
 * 上述url就是：ctx + "system/pdf/pdfViewer?file=/pdf/compressed.tracemonkey-pldi-09.pdf"
 * 例如http://localhost:8090/system/pdf/pdfViewer?file=/pdf/%E8%BD%AF%E4%BB%B6%E8%AE%BE%E8%AE%A1%E8%AF%BE%E5%A0%82%E7%AC%94%E8%AE%B0.pdf
 * @Param:
 * @Return:
 * @Author: yelihu
 * @Date: 2019-08-06 19:33
 */
@Controller
@RequestMapping("/system/pdf")
public class PdfViewerController extends BaseController {

    @GetMapping("/pdfViewer")
    public String viewPdfByPath(HttpServletRequest request)
    {
        return "/pdfViewer";
    }

}
