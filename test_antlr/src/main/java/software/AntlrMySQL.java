package software;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class AntlrMySQL {
    public static void main(String[] args) {
        String sql = "SELECT * " +
                     "FROM product a \n" +
                     "WHERE a.name like '%book%'\n" +
                     "{AND type_ in(:ages)}\n" +
                     "AND status = 'ON_SHELF'";
        final MySqlLexer lexer = new MySqlLexer(CharStreams.fromString(sql));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MySqlParser parser = new MySqlParser(tokens);
        final MySqlParser.DmlStatementContext dmlStatementContext = parser.dmlStatement();
        final MySqlParser.SelectStatementContext selectStatementContext = dmlStatementContext.selectStatement();

        System.out.println(selectStatementContext.toStringTree(parser));
    }
}
