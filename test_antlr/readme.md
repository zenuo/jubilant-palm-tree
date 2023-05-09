## dependency

- jdk11

## run

execute:

```bash
mvn clean compile exec:java -Dexec.mainClass=software.AntlrMySQL
```

output

```
(selectStatement (querySpecification SELECT (selectElements *) (fromClause FROM (tableSources (tableSource (tableSourceItem (tableName (fullId (uid (simpleId product)))) (uid (simpleId a))))) WHERE (expression (expression (expression (predicate (predicate (expressionAtom (fullColumnName (uid (simpleId a)) (dottedId .name)))) like (predicate (expressionAtom (constant (stringLiteral '%book%')))))) (templatePrefix {) (logicalOperator AND) (expression (predicate (predicate (expressionAtom (fullColumnName (uid (simpleId type_))))) in ( (expressions (expression (predicate (expressionAtom (templateParameterClause : (uid (simpleId ages))))))) ))) (templateSuffix })) (logicalOperator AND) (expression (predicate (predicate (expressionAtom (fullColumnName (uid (simpleId (keywordsCanBeId status)))))) (comparisonOperator =) (predicate (expressionAtom (constant (stringLiteral 'ON_SHELF'))))))))))
```

## refrence

- [MySqlLexer.g4](https://raw.githubusercontent.com/antlr/grammars-v4/master/sql/mysql/Positive-Technologies/MySqlLexer.g4)
- [MySqlParser.g4](https://raw.githubusercontent.com/antlr/grammars-v4/master/sql/mysql/Positive-Technologies/MySqlParser.g4)