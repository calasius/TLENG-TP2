// Generated from Musileng.g4 by ANTLR 4.4
package tleng.tp2;

	import java.util.HashMap;
	import java.util.Map;
	import java.util.List;
	import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusilengParser}.
 */
public interface MusilengListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusilengParser#repeticion}.
	 * @param ctx the parse tree
	 */
	void enterRepeticion(@NotNull MusilengParser.RepeticionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#repeticion}.
	 * @param ctx the parse tree
	 */
	void exitRepeticion(@NotNull MusilengParser.RepeticionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#silencio}.
	 * @param ctx the parse tree
	 */
	void enterSilencio(@NotNull MusilengParser.SilencioContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#silencio}.
	 * @param ctx the parse tree
	 */
	void exitSilencio(@NotNull MusilengParser.SilencioContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#nota}.
	 * @param ctx the parse tree
	 */
	void enterNota(@NotNull MusilengParser.NotaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#nota}.
	 * @param ctx the parse tree
	 */
	void exitNota(@NotNull MusilengParser.NotaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(@NotNull MusilengParser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(@NotNull MusilengParser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#elcompas}.
	 * @param ctx the parse tree
	 */
	void enterElcompas(@NotNull MusilengParser.ElcompasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#elcompas}.
	 * @param ctx the parse tree
	 */
	void exitElcompas(@NotNull MusilengParser.ElcompasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#constante}.
	 * @param ctx the parse tree
	 */
	void enterConstante(@NotNull MusilengParser.ConstanteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#constante}.
	 * @param ctx the parse tree
	 */
	void exitConstante(@NotNull MusilengParser.ConstanteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#melodia}.
	 * @param ctx the parse tree
	 */
	void enterMelodia(@NotNull MusilengParser.MelodiaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#melodia}.
	 * @param ctx the parse tree
	 */
	void exitMelodia(@NotNull MusilengParser.MelodiaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#compases}.
	 * @param ctx the parse tree
	 */
	void enterCompases(@NotNull MusilengParser.CompasesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#compases}.
	 * @param ctx the parse tree
	 */
	void exitCompases(@NotNull MusilengParser.CompasesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#tempos}.
	 * @param ctx the parse tree
	 */
	void enterTempos(@NotNull MusilengParser.TemposContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#tempos}.
	 * @param ctx the parse tree
	 */
	void exitTempos(@NotNull MusilengParser.TemposContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#compas}.
	 * @param ctx the parse tree
	 */
	void enterCompas(@NotNull MusilengParser.CompasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#compas}.
	 * @param ctx the parse tree
	 */
	void exitCompas(@NotNull MusilengParser.CompasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#constantes}.
	 * @param ctx the parse tree
	 */
	void enterConstantes(@NotNull MusilengParser.ConstantesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#constantes}.
	 * @param ctx the parse tree
	 */
	void exitConstantes(@NotNull MusilengParser.ConstantesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusilengParser#octava}.
	 * @param ctx the parse tree
	 */
	void enterOctava(@NotNull MusilengParser.OctavaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusilengParser#octava}.
	 * @param ctx the parse tree
	 */
	void exitOctava(@NotNull MusilengParser.OctavaContext ctx);
}