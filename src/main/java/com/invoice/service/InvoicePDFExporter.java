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
import java.util.Date;
import java.util.List;

// https://knpcode.com/java-programs/generating-pdf-java-using-openpdf-tutorial/
// https://www.ulfdittmer.com/view?OpenPDFExample
@AllArgsConstructor
public class InvoicePDFExporter extends PdfPageEventHelper{

    private final List<Invoice> listInvoices;

    // todo: font use Lato
    //https://stackoverflow.com/questions/29575142/how-to-align-two-paragraphs-to-the-left-and-right-on-the-same-line


    private static PdfPCell createLogoCell() throws IOException {
        Image logo = Image.getInstance("src/main/java/com/invoice/images/ZeroEight.png");
        logo.setAlignment(logo.ALIGN_LEFT);
        logo.scalePercent(25, 25);
        PdfPCell cell = new PdfPCell(logo, true);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    private void writeHeaderTable(PdfPTable table) throws IOException {
        PdfPCell cell = new PdfPCell();

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font tableFont = FontFactory.getFont("Lato-Regular");
        tableFont.setSize(9);

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Bold.ttf");
        Font fontHeader = FontFactory.getFont("Lato-Bold");
        fontHeader.setSize(16);


        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(createLogoCell());

//        // NOT SURE IF STATIC METHOD IS BETTER
//        Image logo = Image.getInstance("src/main/java/com/invoice/images/ZeroEight.png");
//        logo.setAlignment(logo.ALIGN_LEFT);

        Paragraph header = new Paragraph("Faktura", fontHeader);
        PdfPTable nestedTable = new PdfPTable(3);

        PdfPTable fakturaSubTable = new PdfPTable(1);
        fakturaSubTable.getDefaultCell().setBorder(0);
        fakturaSubTable.addCell(new Phrase("Fakturadatum", tableFont));
        fakturaSubTable.addCell(new Phrase("Fakturanr", tableFont));
        fakturaSubTable.addCell(new Phrase("OCR", tableFont));

        // Dummy Variables

        String dummyDate = "2022-05-02";
        String dummyNr = "41";
        String dummyOCR = "4143";

        PdfPTable fakturaSubTableInputs = new PdfPTable(1);
        cell.setPhrase(new Phrase(dummyDate,tableFont));
        fakturaSubTableInputs.addCell(cell);
        cell.setPhrase(new Phrase(dummyNr,tableFont));
        fakturaSubTableInputs.addCell(cell);
        cell.setPhrase(new Phrase(dummyOCR,tableFont));
        fakturaSubTableInputs.addCell(cell);

        // Dummy Variables

        String companyName = "eWork Group Ab";
        String lineOne = "Line 1";
        String lineTwo = "Line 2";
        String country = "Sverige";

        PdfPTable companyNameAddressSubTable = new PdfPTable(1);
        cell.setPhrase(new Phrase(companyName,tableFont));
        companyNameAddressSubTable.addCell(cell);
        cell.setPhrase(new Phrase(lineOne,tableFont));
        companyNameAddressSubTable.addCell(cell);
        cell.setPhrase(new Phrase(lineTwo,tableFont));
        companyNameAddressSubTable.addCell(cell);
        cell.setPhrase(new Phrase(country,tableFont));
        companyNameAddressSubTable.addCell(cell);


        nestedTable.getDefaultCell().setBorder(0);
        nestedTable.addCell(header);
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));


        nestedTable.addCell(fakturaSubTable);
        nestedTable.addCell(fakturaSubTableInputs);
        nestedTable.addCell(companyNameAddressSubTable);


        nestedTable.addCell(new Phrase("")); // will take the 3 variables above
        nestedTable.addCell(new Phrase(""));
        nestedTable.addCell(new Phrase(""));
        table.addCell(nestedTable);
    }

    private void writeReferenceTable(PdfPTable table) {

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font tableFont = FontFactory.getFont("Lato-Regular");
        tableFont.setSize(10);


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
        cell.setBorder(Rectangle.BOTTOM | Rectangle.TOP);

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
        font.setSize(11);

        //todo: change font in doc


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
        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
        font.setSize(11);

        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        for (Invoice invoice : listInvoices) {
            cell.setPhrase(new Phrase(String.valueOf(invoice.getInvoiceNumber()),font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(invoice.getCompanyAddress()),font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(invoice.getCompanyName()),font));
            table.addCell(cell);
            cell.setPhrase(new Phrase(String.valueOf(invoice.getEmailAddress()),font));
            table.addCell(cell);
        }
//        for (Invoice invoice : listInvoices) {
//            table.addCell(String.valueOf(invoice.getInvoiceNumber()));
//            table.addCell(invoice.getCompanyAddress());
//            table.addCell(invoice.getCompanyName());
//            table.addCell(invoice.getEmailAddress());
//        }
    }

    private void writeSummaryTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        PdfPCell cell1 = new PdfPCell(); // 2 instances so we get bottom underline

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
        font.setSize(11);

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Bold.ttf");
        Font attBatalaHeaderFont = FontFactory.getFont("Lato-Bold");
        attBatalaHeaderFont.setSize(11);

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Bold.ttf");
        Font attBatalaFont = FontFactory.getFont("Lato-Bold");
        attBatalaFont.setSize(12);

        cell.setBorder(Rectangle.TOP);
        cell1.setBorder(Rectangle.BOTTOM);

        table.setWidthPercentage(100);

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

    }
    private void writeBankTable(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
        font.setSize(11);

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Bold.ttf");
        Font fontBold = FontFactory.getFont("Lato-Bold");
        fontBold.setSize(11);

        // Sets the lines for the Table
        cell.setBorder(Rectangle.NO_BORDER);

        table.setWidthPercentage(100);

        double monsRate= 25;
        double mons = 33066.09;
        cell.setPhrase(new Phrase("Moms "+monsRate+"% "+mons, font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("IBAN", fontBold));
        table.addCell(cell);
        cell.setPhrase(new Phrase("BIC", fontBold));
        table.addCell(cell);
    }

    private void writeContactInfo(PdfPTable table) {
        PdfPCell cell = new PdfPCell();

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
        font.setSize(10);

        cell.setBorder(Rectangle.NO_BORDER);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        table.setWidthPercentage(100);

        // todo: padding

        PdfPTable addressTable = new PdfPTable(1);
        addressTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        cell.setPhrase(new Phrase("Adress", font));
        addressTable.addCell(cell);
        cell.setPhrase(new Phrase("Zero8 AB", font));
        addressTable.addCell(cell);
        cell.setPhrase(new Phrase("Gripens väg 15", font));
        addressTable.addCell(cell);
        cell.setPhrase(new Phrase("TULLINGE", font));
        addressTable.addCell(cell);
        cell.setPhrase(new Phrase("Sverige", font));
        addressTable.addCell(cell);
        table.addCell(addressTable);

        PdfPTable phoneAndEmailTable = new PdfPTable(1);
        phoneAndEmailTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cell.setPhrase(new Phrase("Telefon", font));
        phoneAndEmailTable.addCell(cell);
        cell.setPhrase(new Phrase("343-443434", font));
        phoneAndEmailTable.addCell(cell);
        cell.setPhrase(new Phrase("E-post", font));
        phoneAndEmailTable.addCell(cell);
        cell.setPhrase(new Phrase("Email@Email.se", font));
        phoneAndEmailTable.addCell(cell);
        table.addCell(phoneAndEmailTable);


        PdfPTable bankgiroTable = new PdfPTable(1);
        bankgiroTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cell.setPhrase(new Phrase("Bankgiro", font));
        bankgiroTable.addCell(cell);
        cell.setPhrase(new Phrase("555-555", font));
        bankgiroTable.addCell(cell);
        table.addCell(bankgiroTable);

        PdfPTable organisationTable = new PdfPTable(1);
        organisationTable.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cell.setPhrase(new Phrase("Organisationsnr", font));
        organisationTable.addCell(cell);
        cell.setPhrase(new Phrase("558745-1458", font));
        organisationTable.addCell(cell);
        cell.setPhrase(new Phrase("Momsreg. nr", font));
        organisationTable.addCell(cell);
        cell.setPhrase(new Phrase("SE125684523652", font));
        organisationTable.addCell(cell);
        cell.setPhrase(new Phrase("GodKänd för F-skatt", font));
        organisationTable.addCell(cell);
        table.addCell(organisationTable);

    }

    private HeaderFooter footer (Document document) {
        // headers and footers must be added before the document is opened
        int numberOfPages = document.getPageNumber(); //todo: total page numbers in ()

        FontFactory.register("src/main/java/com/invoice/Font/Lato-Regular.ttf");
        Font font = FontFactory.getFont("Lato-Regular");
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

        // Bank Table
        PdfPTable bankTable = new PdfPTable(3);
        writeBankTable(bankTable);

        // Contact information Table
        PdfPTable contactInfoTable = new PdfPTable(4);
        writeContactInfo(contactInfoTable);
        contactInfoTable.setSpacingBefore(5);


        // document build
        document.add(headerTable);
        document.add(referenceTable);
        document.add(invoiceTable);
        document.add(summaryTable);
        document.add(bankTable);
        document.add(contactInfoTable);
        document.close();
    }

}
