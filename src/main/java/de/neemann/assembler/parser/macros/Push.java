package de.neemann.assembler.parser.macros;

import de.neemann.assembler.asm.*;
import de.neemann.assembler.expression.Constant;
import de.neemann.assembler.expression.ExpressionException;
import de.neemann.assembler.parser.Macro;
import de.neemann.assembler.parser.Parser;
import de.neemann.assembler.parser.ParserException;

import java.io.IOException;

/**
 * @author hneemann
 */
public class Push implements Macro {
    @Override
    public String getName() {
        return "_PUSH";
    }

    @Override
    public void parseMacro(Program p, String name, Parser parser) throws IOException, ParserException, InstructionException, ExpressionException {
        Register r = parser.parseReg();
        p.setPendingMacroDescription(getName() + " " + r.name());
        push(r, p);
    }

    public static void push(Register r, Program p) throws InstructionException {
        p.add(Instruction.make(Opcode.SUBIs, Register.SP, new Constant(1)));
        p.add(Instruction.make(Opcode.ST, Register.SP, r));
    }
}
