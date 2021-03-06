package de.neemann.assembler.asm;

import de.neemann.assembler.expression.Context;
import de.neemann.assembler.expression.ExpressionException;

/**
 * The Programm visitor.
 * Visits all instruction of a program
 *
 * @author hneemann
 */
public interface InstructionVisitor {

    /**
     * Visits an instruction
     *
     * @param instruction the instruction
     * @param context     the context of the instruction in the program
     * @return false if iteration is to terminate
     * @throws ExpressionException ExpressionException
     */
    boolean visit(InstructionInterface instruction, Context context) throws ExpressionException;

}
