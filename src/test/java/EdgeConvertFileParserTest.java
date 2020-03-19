import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class EdgeConvertFileParserTest{
    EdgeConvertFileParser fileParser;

    /** 
     * Open the file before the test method
     */
    @Before
    public void start(){
        fileParser = new EdgeConvertFileParser(new File("Courses.edg"));
    }

    /**
     * Check the tables data if there is not null for data
     */
    @Test
    public void testTablesExists() {
        assertTrue("Checking for tables data exists", (fileParser.getEdgeTables() != null));   
    }

    /**
     * Check the fields data if there is not null for data
     */
    @Test
    public void testFieldsExists() {
        assertTrue("Checking for fields data exists", (fileParser.getEdgeFields() != null));   
    }

    /**
     * Find and match the first name of field for "grade"
     */
    @Test
    public void testFirstElementField(){
        assertTrue("Initiated data field with first data to Grade", fileParser.getEdgeFields()[0].getName().equals("Grade") );
    }

    /**
     * Find and match the first name of table for "student"
     */
    @Test
    public void testFirstElementTable(){
        assertTrue("Initiated data table with first data to name STUDENT", fileParser.getEdgeTables()[0].getName().equals("STUDENT") );
    }

    /**
     * Set the table for array size to 3
     */   
    @Test
    public void testSizeOfTables(){
        assertEquals("construction for file parser initiated to 3 array for tables", 3, fileParser.getEdgeTables().length );
    }

    /**
     * Set the field for array size to 7
     */    
    @Test
    public void testSizeOfFields(){
        assertEquals("Initiate construction for fields to 7", 7, fileParser.getEdgeFields().length);
    }

    /**
     * Set the disallow null to true and is expecting the same answer in return
     */       
    @Test
    public void testDisallowNull(){
        fileParser.getEdgeFields()[0].setDisallowNull(true);;
        assertEquals("expected", true, fileParser.getEdgeFields()[0].getDisallowNull());
    }

    /**
     * Check the first table data for number figure to 1
     */       
    @Test
    public void testTableNumFigure(){
        assertEquals("First Table array initiated to number figure 1", 1, fileParser.getEdgeTables()[0].getNumFigure());
    }

    /**
     * Check the first field data for number figure to 3
     */       
    @Test
    public void testFieldNumFigure(){
        assertEquals("First Field array initiated to number figure 3", 3, fileParser.getEdgeFields()[0].getNumFigure());
    }

    /**
     * Set the varchar type to 2 and is expecting the same answer in return
     */   
    @Test
    public void testChangeVarcharValue(){
        fileParser.getEdgeFields()[0].setVarcharValue(2);
        assertEquals("Configure varchar type to 2", 2, fileParser.getEdgeFields()[0].getVarcharValue());
    }

    /**
     * Set the field bound to 10 and is expecting the same answer in return
     */   
    @Test
    public void testUpdateFieldBound(){
        fileParser.getEdgeFields()[0].setFieldBound(10);
        assertEquals("Set field bound to 10", 10, fileParser.getEdgeFields()[0].getFieldBound() );
    }

    /**
     * Set the primary key to true and is expecting the same answer in return
     */   
    @Test
    public void testUpdatePrimaryKey(){
        fileParser.getEdgeFields()[0].setIsPrimaryKey(true);
        assertTrue("Set primary key to true", fileParser.getEdgeFields()[0].getIsPrimaryKey());;
    }
}