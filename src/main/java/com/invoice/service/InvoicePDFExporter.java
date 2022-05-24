package com.invoice.service;

import com.invoice.entity.Invoice;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;
import lombok.AllArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

// https://knpcode.com/java-programs/generating-pdf-java-using-openpdf-tutorial/
// https://www.ulfdittmer.com/view?OpenPDFExample
@AllArgsConstructor
public class InvoicePDFExporter extends PdfPageEventHelper{

    private final List<Invoice> listInvoices;

    // todo: font use Lato
    // todo: logo and first table should be side by side
    //https://stackoverflow.com/questions/29575142/how-to-align-two-paragraphs-to-the-left-and-right-on-the-same-line
    //


    private void writeHeaderTable(PdfPTable table) throws IOException {

        Font tableFont = FontFactory.getFont(FontFactory.HELVETICA);
        tableFont.setColor(Color.BLACK);
        tableFont.setSize(10);

        PdfPCell cell = new PdfPCell();
        // Sets the lines for the Table
        cell.setPadding(5);
        cell.setBorder(Rectangle.NO_BORDER);

        //todo: Create method that returns Image in cell
        Image logo = Image.getInstance("src/main/java/com/invoice/images/ZeroEight.png");
        logo.setAlignment(logo.ALIGN_LEFT);
        logo.scalePercent(25, 25);
        table.addCell(logo);

        Font fontHeader = new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK);
        Paragraph header = new Paragraph("Faktura", fontHeader);
        header.setAlignment(Element.ALIGN_RIGHT); // Not working

        PdfPTable nestedTable = new PdfPTable(3);

        nestedTable.getDefaultCell().setBorder(0);
        nestedTable.addCell(header);
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase("\nFakturadatum"+" \nFakturanr \nOCR", tableFont));
        nestedTable.addCell(new Phrase("")); // will take the 3 variables above
        nestedTable.addCell(new Phrase("Company Name" + "\nLine 1" + "\nLine 2" + "\nLine 3", tableFont));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));

        table.addCell(nestedTable);
    }

    private void writeReferenceTable(PdfPTable table) {

        Font tableFont = FontFactory.getFont(FontFactory.HELVETICA);
        tableFont.setColor(Color.BLACK);
        tableFont.setSize(11);

        table.addCell(new Phrase("Kundnr",tableFont));
        table.addCell(new Phrase("Some number",tableFont));
        table.addCell(new Phrase("Vår referens",tableFont));
        table.addCell(new Phrase("Some name",tableFont));

        table.addCell(new Phrase("Er referens",tableFont));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Betalningsvillkor",tableFont));
        table.addCell(new Phrase(""));

        table.addCell(new Phrase(""));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Förfallodatum",tableFont));
        table.addCell(new Phrase(""));

        table.addCell(new Phrase(""));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Dröjsmålsränta",tableFont));
        table.addCell(new Phrase(""));
    }


    private void writeInvoiceTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE); //colour change later
        cell.setPadding(5);
        cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);

        // Font
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change
        font.setSize(12);

        cell.setPhrase(new Phrase("Artnr", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Benämning", font));
        table.addCell(cell);
        // todo change to 5 columns and uncomment when we have a DB table connected
//        cell.setPhrase(new Phrase("Lev ant", font));
//        table.addCell(cell);

        cell.setPhrase(new Phrase("A-pris", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Summa", font));
        table.addCell(cell);
    }

    private void writeInvoiceTableData(PdfPTable table) {
        for (Invoice invoice : listInvoices) {
            table.addCell(String.valueOf(invoice.getInvoiceNumber()));
            table.addCell(invoice.getCompanyAddress());
            table.addCell(invoice.getCompanyName());
            table.addCell(invoice.getEmailAddress());
        }
    }

    private void writeSummaryTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        PdfPCell cell1 = new PdfPCell();

        cell.setPadding(5);
        cell.setBorder(Rectangle.TOP);

        cell1.setPadding(5);
        cell1.setBorder(Rectangle.BOTTOM);
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change
        Font attBatalaHeaderFont = new Font(Font.HELVETICA, 11, Font.BOLD, Color.BLACK);
        Font attBatalaFont = new Font(Font.HELVETICA, 12, Font.BOLD, Color.BLACK);

        table.setWidthPercentage(100);
        //table.getDefaultCell().setBorder(0);

        cell.setPhrase(new Phrase("Exkl. moms", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Öresavr", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Totalt", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ATT BATALA", attBatalaHeaderFont));
        table.addCell(cell);
        table.completeRow();
        String testVar = "some number";

        cell1.setPhrase(new Phrase(testVar, font));
        table.addCell(cell1);
        cell1.setPhrase(new Phrase("ghgh", font));
        table.addCell(cell1);
        cell1.setPhrase(new Phrase(String.valueOf(344433), font));
        table.addCell(cell1);
        cell1.setPhrase(new Phrase("7676", font));
        table.addCell(cell1);
        cell1.setPhrase(new Phrase("SEK"+" 165 125,00", attBatalaFont));
        table.addCell(cell1);

        // todo: need a line at the bottom

    }
    private void writeBankTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        // Sets the lines for the Table
        cell.setBackgroundColor(Color.WHITE); //colour change later
        cell.setPadding(5);
        cell.setBorder(Rectangle.NO_BORDER);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change

        table.setWidthPercentage(100);
        // todo: padding

        int mons = 25;
        cell.setPhrase(new Phrase("Moms "+mons+"%", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms", font));
        table.addCell(cell);
        table.completeRow();
    }

    private void writeContactInfo(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        // Sets the lines for the Table
        cell.setBackgroundColor(Color.WHITE); //colour change later
        cell.setPadding(5);
        cell.setBorder(Rectangle.NO_BORDER);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change

        table.setWidthPercentage(100);
        // todo: padding

        int mons = 25;
        cell.setPhrase(new Phrase("Adress \nZero8 AB \nGripens väg 15 \n14635 TULLINGE \nSverige"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms "+mons+"%", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms", font));
        table.addCell(cell);

        table.completeRow();
    }

    private HeaderFooter footer (Document document) {
        // headers and footers must be added before the document is opened
        int numberOfPages = document.getPageNumber(); //todo: total page numbers in ()

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change
        font.setSize(8);

        //HeaderFooter pageNumber = new HeaderFooter(new Phrase("Sida ("+numberOfPages+")", new Font(font)), true );
        HeaderFooter pageNumber = new HeaderFooter(new Phrase("Sida ", new Font(font)), true );
        pageNumber.setBorder(Rectangle.NO_BORDER);
        pageNumber.setAlignment(Element.ALIGN_RIGHT);
        return pageNumber;
    }


    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4 , 50, 50, 50, 50);
        PdfWriter.getInstance(document, response.getOutputStream());
        // header footer must be called before doc is open
        document.setHeader(footer(document));
        document.open();

        // Header Table
        PdfPTable headerTable = new PdfPTable(2);
        headerTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        headerTable.setWidthPercentage(100f);
        headerTable.setSpacingAfter(30f);
        writeHeaderTable(headerTable);


        // reference table
        PdfPTable referenceTable = new PdfPTable(4);
        referenceTable.setWidthPercentage(100);
        referenceTable.getDefaultCell().setBorder(0); // removes borderline
        referenceTable.setSpacingAfter(10f);
        writeReferenceTable(referenceTable);


        // Main Table
        // todo change to 5 columns when we have a DB table connected
        PdfPTable invoiceTable = new PdfPTable(4);
        invoiceTable.setWidthPercentage(100);
        invoiceTable.setSpacingBefore(10);
        invoiceTable.setSpacingAfter(230);
        invoiceTable.getDefaultCell().setBorder(0); // removes borderline

        // Table headers and Data
        writeInvoiceTable(invoiceTable);
        writeInvoiceTableData(invoiceTable);

        // Summary Table
        PdfPTable summaryTable = new PdfPTable(5);
        summaryTable.setWidthPercentage(100);
        summaryTable.setSpacingAfter(5);
        writeSummaryTable(summaryTable);

        //
        PdfPTable table4 = new PdfPTable(2);
        writeBankTable(table4);

        //
        PdfPTable table5 = new PdfPTable(4);
        writeContactInfo(table5);

        // document build
        document.add(headerTable);
        document.add(referenceTable);
        document.add(invoiceTable);
        document.add(summaryTable);
        document.add(table4);
        document.add(table5);

        document.close();
    }

}
