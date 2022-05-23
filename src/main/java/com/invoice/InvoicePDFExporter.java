package com.invoice;

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
public class InvoicePDFExporter {

    private final List<Invoice> listInvoices;

    // todo: font use Lato
    // todo: logo and first table should be side by side
    //https://stackoverflow.com/questions/29575142/how-to-align-two-paragraphs-to-the-left-and-right-on-the-same-line
    //


    private void writeFakturaTable(PdfPTable table) throws IOException {
//        todo: Rename variables
        // todo make table 3x3
        // todo fix font

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change

        PdfPCell cell = new PdfPCell();
        // Sets the lines for the Table
        cell.setPadding(5);
        cell.setBorder(Rectangle.NO_BORDER);

        // Font
//        Font font = FontFactory.getFont(FontFactory.HELVETICA );
//        font.setColor(Color.BLACK); // Font colour change
//        font.setSize(12);

//        todo: Set fonts variables

        Image image = Image.getInstance("src/main/java/com/invoice/images/ZeroEight.png");
        image.setAlignment(image.ALIGN_LEFT);
        image.scalePercent(25, 25);

        table.addCell(image);

        Font fontHeader = new Font(Font.HELVETICA, 16, Font.BOLD, Color.BLACK);
        Paragraph header = new Paragraph("Faktura", fontHeader);
        header.setAlignment(Element.ALIGN_RIGHT); // Not working

        PdfPTable nestedTable = new PdfPTable(3);


        nestedTable.getDefaultCell().setBorder(0);
        header.setAlignment(Element.ALIGN_RIGHT); // Not working
        nestedTable.addCell(header);
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase("\nFakturadatum"+" \nFakturanr \nOCR"));
        nestedTable.addCell(new Phrase("")); // will take the 3 variables above
        nestedTable.addCell(new Phrase("Company Name" + "\nLine 1" + "\nLine 2" + "\nLine 3", font));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));

        table.addCell(nestedTable);
    }

    private void writeReferenceTable(PdfPTable table) {
        table.addCell(new Phrase("Kundnr"));
        table.addCell(new Phrase("Some number"));
        table.addCell(new Phrase("Vår referens"));
        table.addCell(new Phrase("Some name"));

        table.addCell(new Phrase("Er referens"));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Betalningsvillkor"));
        table.addCell(new Phrase(""));

        table.addCell(new Phrase(""));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Förfallodatum"));
        table.addCell(new Phrase(""));

        table.addCell(new Phrase(""));
        table.addCell(new Phrase(""));
        table.addCell(new Phrase("Dröjsmålsränta"));
        table.addCell(new Phrase(""));


    }


    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        // Sets the lines for the Table
        cell.setBackgroundColor(Color.WHITE); //colour change later
        cell.setPadding(5);
        cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);



        // Font
        Font font = FontFactory.getFont(FontFactory.HELVETICA );
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



    private void writeTableData(PdfPTable table) {
        for (Invoice invoice : listInvoices) {
            table.addCell(String.valueOf(invoice.getInvoiceNumber()));
            table.addCell(invoice.getCompanyAddress());
            table.addCell(invoice.getCompanyName());
            table.addCell(invoice.getEmailAddress());
        }
    }

    // Table in footer
    private void writeFooterTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        // Sets the lines for the Table
        cell.setBackgroundColor(Color.WHITE); //colour change later
        cell.setPadding(5);
        cell.setBorder(Rectangle.TOP);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change

        table.setWidthPercentage(100);
        table.getDefaultCell().setBorder(0);

        cell.setPhrase(new Phrase("Invoice Num", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Moms", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Öresavr", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Totalt", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ATT BATALA", font));
        table.addCell(cell);
        table.completeRow();

        String testVar = "some number";

        cell.setPhrase(new Phrase(testVar, font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ghgh", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase(String.valueOf(344433), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Totalt", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ATT BATALA", font));
        table.addCell(cell);
        table.completeRow();

        // todo: need a line at the bottom


//        table.setWidthPercentage(100);
//        for (int i = 0; i < 5; i++) {
//            table.addCell(new PdfPCell(new Paragraph("CONTENTe")));
//            table.addCell(new PdfPCell(new Paragraph("CONTENTe")));
//            table.addCell(new PdfPCell(new Paragraph("CONTENTe")));
//            table.addCell(new PdfPCell(new Paragraph("CONTENTe")));
//            table.addCell(new PdfPCell(new Paragraph("CONTENTe")));
//        }
        // table.completeRow();

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

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK); // Font colour change

//        BaseFont bf_helvetica = BaseFont.createFont(BaseFont.HELVETICA, "Cp1252", false);
//        HeaderFooter pageNumber = new HeaderFooter(new Phrase("Sida : ", font, true));
        int numberOfPages = document.getPageNumber(); // total page number

        HeaderFooter pageNumber = new HeaderFooter(new Phrase("Sida : "), true);

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


        // Main Table
        // todo change to 5 columns when we have a DB table connected
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10);
        table.setSpacingAfter(100f);
        table.getDefaultCell().setBorder(0); // removes borderline



        // Table headers and Data
        writeTableHeader(table);
        writeTableData(table);


        // Nested Table
        PdfPTable table2 = new PdfPTable(2);
        table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table2.setWidthPercentage(100f);
        table2.setSpacingAfter(30f);
        //table2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        writeFakturaTable(table2);


        // Bottom Table
        PdfPTable table3 = new PdfPTable(5);
        table3.setWidthPercentage(100);
        //table3.setSpacingBefore(60);
        table3.getDefaultCell().setBorder(0); // removes borderline

        // reference table
        PdfPTable table6 = new PdfPTable(4);
        table6.setWidthPercentage(100);
        table6.getDefaultCell().setBorder(0); // removes borderline
        table6.setSpacingAfter(10f);
        writeReferenceTable(table6);

        // Bottom Table

        writeFooterTable(table3);

        //
        PdfPTable table4 = new PdfPTable(2);
        writeBankTable(table4);

        //
        PdfPTable table5 = new PdfPTable(4);
        writeContactInfo(table5);

        // document build
        document.add(table2);
        document.add(table6);
        document.add(table);
        document.add(table3);
        document.add(table4);
        document.add(table5);

        document.close();
    }

}
