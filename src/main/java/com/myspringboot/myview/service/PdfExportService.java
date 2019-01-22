package com.myspringboot.myview.service;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */


public interface PdfExportService {
    public void make(Map<String,Object> model, Document doucument, PdfWriter writer,HttpServletRequest request,HttpServletResponse response);
}
