package api.dao;

public class ProductDAO {

    MotorSQL motorsql;
    String sql;

    public static final SQL_INSERT = "INSERT INTO PRODUCT ";
    public static final SQL_FIND = "SELECT * FROM PRODUCT WHERE 1=1 ";

    public ProductDAO(){
        motorsql= new MotorSQL();
    }

    public void bajaProductoDAO(){

        sql = SQL_FIND;
        ResultSet rs = motorsql.executeQuery(sql);

    }
    public void altaProductoDAO(){
        
    }
    public void listarProductosDAO(){

        sql = SQL_FIND;
        ResultSet rs = motorsql.executeQuery(sql);
        
    }
    public void modificarProductosDAO(){
        
    }
}
