package com.myspringboot.myview.controller;





import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.myspringboot.myview.PdfView;
import com.myspringboot.myview.service.PdfExportService;
import com.myspringboot.transaction.PersonMapper;
import com.myspringboot.transaction.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.awt.*;
import java.util.List;

import static java.awt.Color.BLUE;

/**
 * @Auther: 陈晖
 * @Date:2019/1/22 0022
 * @Descroption:
 */

@Controller
public class MyController {
    @Autowired
    PersonMapper personMapper;

    @RequestMapping("pdf")
    public ModelAndView exportPdf(){
        List<Person> list=personMapper.selectAll();
        View view=new PdfView(exportService());
        ModelAndView mv=new ModelAndView();
        mv.setView(view);
        mv.addObject("list",list);
        return  mv;
    }

    @SuppressWarnings("unchecked")
    private PdfExportService exportService(){
        return (model,document,writer,request,response)->{
          try{
              document.setPageSize(PageSize.A4);
              document.addTitle("用户信息");
              document.add(new Chunk("用户信息"));
              PdfPTable table=new PdfPTable(3);
              PdfPCell cell=null;
              com.lowagie.text.Font f8=new com.lowagie.text.Font();

              f8.setStyle(Font.BOLD);
              cell=new PdfPCell(new Paragraph("id",f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);
              cell=new PdfPCell(new Paragraph("username",f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);
              cell=new PdfPCell(new Paragraph("note",f8));
              cell.setHorizontalAlignment(1);
              table.addCell(cell);
              //去除模型中的列表
              List<Person> list=(List<Person>)model.get("list");
              for(Person person:list){
                  document.add(new Chunk("\n"));
                  cell=new PdfPCell(new Paragraph(person.getId()+""));
                  table.addCell(cell);
                  cell=new PdfPCell(new Paragraph(person.getName()+""));
                  table.addCell(cell);
                  cell=new PdfPCell(new Paragraph(null+""));
                  table.addCell(cell);
              }
              document.add((Element) table);
          }  catch (Exception e){
                e.printStackTrace();
          }
        };
    }
}
