package old_school;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        persistBook(new BookOldSchool(1L,"H2G2","Best Scifi Book",12.5f,"1234-5678-5678"));
        BookOldSchool bookOldSchool = findBook(1L);
    }

    //Persisting a Book to the Database
    static void persistBook(BookOldSchool bookOldSchool) {
        String query = "INSERT INTO BOOK (ID, TITLE, DESCRIPTION, UNITCOST, ISBN) VALUES (?,?,?,?,?)";
        try(PreparedStatement stmt = getConnection().prepareStatement(query)) {
            stmt.setLong(1, bookOldSchool.getId());
            stmt.setString(2, bookOldSchool.getTitle());
            stmt.setString(3, bookOldSchool.getDescription());
            stmt.setFloat(4, bookOldSchool.getUnitCost());
            stmt.setString(5, bookOldSchool.getIsbn());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static BookOldSchool findBook(Long id){
        BookOldSchool bookOldSchool = new BookOldSchool();
        String query = "SELECT ID, TITLE, DESCRIPTION, UNICOST, ISBN FROM BOOK WHERE ID = ?";
        try(PreparedStatement stmt = getConnection().prepareStatement(query)){
            stmt.setFloat(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                bookOldSchool.setId(rs.getLong(1));
                bookOldSchool.setTitle(rs.getString("TITLE"));
                bookOldSchool.setTitle(rs.getString("DESCRIPTION"));
                bookOldSchool.setTitle(rs.getString("UNICOST"));
                bookOldSchool.setTitle(rs.getString("ISBN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookOldSchool;
    }

    static {
        try{
            Class.forName("org.h2.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:module01-db");
    }
}
