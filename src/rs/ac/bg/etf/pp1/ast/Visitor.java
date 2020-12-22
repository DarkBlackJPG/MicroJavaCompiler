// generated with ast extension for cup
// version 0.8
// 22/11/2020 1:40:0


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ReturnType ReturnType);
    public void visit(MethodVariables MethodVariables);
    public void visit(MethodDeclarations MethodDeclarations);
    public void visit(MethodDeclaration MethodDeclaration);
    public void visit(PrintStmtList PrintStmtList);
    public void visit(StatementList StatementList);
    public void visit(CaseStatementList CaseStatementList);
    public void visit(VariableList VariableList);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(ConstList ConstList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(CondFactor CondFactor);
    public void visit(ClassBody ClassBody);
    public void visit(CondExpression CondExpression);
    public void visit(TernaryExpr TernaryExpr);
    public void visit(ClassMethodList ClassMethodList);
    public void visit(MulOp MulOp);
    public void visit(VariableDeclarations VariableDeclarations);
    public void visit(SwitchCaseList SwitchCaseList);
    public void visit(Literals Literals);
    public void visit(RelOp RelOp);
    public void visit(RegularExpr RegularExpr);
    public void visit(Declarations Declarations);
    public void visit(ReturnStmts ReturnStmts);
    public void visit(Expr Expr);
    public void visit(ClassDeclaration ClassDeclaration);
    public void visit(ActPars ActPars);
    public void visit(DesignatorList DesignatorList);
    public void visit(AddOp AddOp);
    public void visit(VariableDeclaration VariableDeclaration);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(Const Const);
    public void visit(Statement Statement);
    public void visit(Decls Decls);
    public void visit(FieldList FieldList);
    public void visit(FormPars FormPars);
    public void visit(MulopModulo MulopModulo);
    public void visit(MulopDivide MulopDivide);
    public void visit(MulopTimes MulopTimes);
    public void visit(AddopMinus AddopMinus);
    public void visit(AddopPlus AddopPlus);
    public void visit(AssignOp AssignOp);
    public void visit(RelopLessEqual RelopLessEqual);
    public void visit(RelopLessThan RelopLessThan);
    public void visit(RelopLargerEqual RelopLargerEqual);
    public void visit(RelopLargerThan RelopLargerThan);
    public void visit(RelopNotEqual RelopNotEqual);
    public void visit(RelopEquals RelopEquals);
    public void visit(Type Type);
    public void visit(ArrayElementDesignatorList ArrayElementDesignatorList);
    public void visit(FieldCallDesignatorList FieldCallDesignatorList);
    public void visit(CleanDesignatorList CleanDesignatorList);
    public void visit(ArrayElementDesignator ArrayElementDesignator);
    public void visit(FieldCallDesignator FieldCallDesignator);
    public void visit(CleanDesignator CleanDesignator);
    public void visit(ActParsWithComma ActParsWithComma);
    public void visit(ActParsWithoutComma ActParsWithoutComma);
    public void visit(ParenthesesExpression ParenthesesExpression);
    public void visit(NewTypeArray NewTypeArray);
    public void visit(NewType NewType);
    public void visit(BooleanConstant BooleanConstant);
    public void visit(CharacterConstant CharacterConstant);
    public void visit(NumericConstant NumericConstant);
    public void visit(ParamsDesignator ParamsDesignator);
    public void visit(NoParamsDesignator NoParamsDesignator);
    public void visit(MullOpTerm MullOpTerm);
    public void visit(NonMullOpTerm NonMullOpTerm);
    public void visit(TernaryExpressionStmt TernaryExpressionStmt);
    public void visit(AddOperationTerm AddOperationTerm);
    public void visit(NegativeTerm NegativeTerm);
    public void visit(ExpressionTerm ExpressionTerm);
    public void visit(TernaryExprProduction TernaryExprProduction);
    public void visit(RegularExprProduction RegularExprProduction);
    public void visit(RelOpConditionFactor RelOpConditionFactor);
    public void visit(ExpressionConditionFactor ExpressionConditionFactor);
    public void visit(ConditionTermFactor ConditionTermFactor);
    public void visit(ConditionTermWithAnd ConditionTermWithAnd);
    public void visit(ConditionExpressionWithOr ConditionExpressionWithOr);
    public void visit(ConditionExpressionWithoutOr ConditionExpressionWithoutOr);
    public void visit(EmptyReturn EmptyReturn);
    public void visit(NonEmptyReturn NonEmptyReturn);
    public void visit(Condition Condition);
    public void visit(DecrementDesignator DecrementDesignator);
    public void visit(IncrementDesignator IncrementDesignator);
    public void visit(MethodCallDesignator MethodCallDesignator);
    public void visit(AssignDesignator AssignDesignator);
    public void visit(EmptyStatement EmptyStatement);
    public void visit(NonEmptyStatementList NonEmptyStatementList);
    public void visit(WithNumConst WithNumConst);
    public void visit(NoNumConst NoNumConst);
    public void visit(EmptyCaseStatementList EmptyCaseStatementList);
    public void visit(NonEmptyCaseStatementList NonEmptyCaseStatementList);
    public void visit(NonEmptySwitchCaseList NonEmptySwitchCaseList);
    public void visit(EmptySwitchCaseList EmptySwitchCaseList);
    public void visit(StatementsList StatementsList);
    public void visit(PrintStmt PrintStmt);
    public void visit(ReadStmt ReadStmt);
    public void visit(ReturnStmt ReturnStmt);
    public void visit(ContinueStmt ContinueStmt);
    public void visit(BreakStmt BreakStmt);
    public void visit(SwitchStatement SwitchStatement);
    public void visit(DoWhileStatement DoWhileStatement);
    public void visit(IfThenElseStatement IfThenElseStatement);
    public void visit(IfThenStatement IfThenStatement);
    public void visit(StatementDesignatorStatement StatementDesignatorStatement);
    public void visit(NoVariables NoVariables);
    public void visit(HasMethodVariables HasMethodVariables);
    public void visit(VoidReturn VoidReturn);
    public void visit(TypedReturn TypedReturn);
    public void visit(OneMethodDeclaration OneMethodDeclaration);
    public void visit(NoMethods NoMethods);
    public void visit(HasMethods HasMethods);
    public void visit(NoFields NoFields);
    public void visit(HasFieldVariables HasFieldVariables);
    public void visit(ClassBodyWithoutMethods ClassBodyWithoutMethods);
    public void visit(ClassBodyWithMethods ClassBodyWithMethods);
    public void visit(ChildClass ChildClass);
    public void visit(RootClass RootClass);
    public void visit(ArrayVariable ArrayVariable);
    public void visit(NonArrayVariable NonArrayVariable);
    public void visit(MoreVariables MoreVariables);
    public void visit(SingleVariable SingleVariable);
    public void visit(VariableDecls VariableDecls);
    public void visit(BooleanLiteral BooleanLiteral);
    public void visit(CharLiteral CharLiteral);
    public void visit(NumericLiteral NumericLiteral);
    public void visit(ConstDefinition ConstDefinition);
    public void visit(MoreConsts MoreConsts);
    public void visit(SingleConst SingleConst);
    public void visit(ClassDeclarations ClassDeclarations);
    public void visit(VarDeclarations VarDeclarations);
    public void visit(ConstDeclarations ConstDeclarations);
    public void visit(NoDecls NoDecls);
    public void visit(DeclarationList DeclarationList);
    public void visit(Program Program);

}
