package com.myspringboot.myview;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.myspringboot.myview.service.PdfExportService;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */


public class PdfView extends AbstractPdfView {
    private PdfExportService pdfExportService;

    public PdfView(PdfExportService pdfExportService){
        this.pdfExportService=pdfExportService;
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        pdfExportService.make(model,document,writer,request,response);
    }
}
