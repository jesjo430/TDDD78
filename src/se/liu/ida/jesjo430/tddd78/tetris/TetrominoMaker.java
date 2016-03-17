package se.liu.ida.jesjo430.tddd78.tetris;

import static se.liu.ida.jesjo430.tddd78.tetris.SquareType.*;

/**
 * Creates the two-dimantional arrays that corresponds with the blocktypes.
 */

public final class TetrominoMaker
{
    private TetrominoMaker() {
    }

    public static int getNumberOfTypes() {
        return values().length;
    }

    /**
     * returns the n:th squaretype.
     * else IndexOutOf Bounds.
     */
    public static Poly getPoly(int n) {
        switch (n) {
            case -1:
                return new Poly(createEMPTYBlock());
            case 0:
                return new Poly(createIBlock());
            case 1:
                return new Poly(createJBlock());
            case 2:
                return new Poly(createLBlock());
            case 3:
                return new Poly(createOBlock());
            case 4:
                return new Poly(createSBlock());
            case 5:
                return new Poly(createTBlock());
            case 6:
                return new Poly(createZBlock());
            default:
                throw new IndexOutOfBoundsException("Index " + n + " does not match any block.");
        }
    }

    private static SquareType[][] createIBlock() {
        return new SquareType[][]{
            { EMPTY, EMPTY, EMPTY, EMPTY},
            { I, I, I, I },
            { EMPTY, EMPTY, EMPTY, EMPTY},
            { EMPTY, EMPTY, EMPTY, EMPTY},
        };
    }

    private static SquareType[][] createJBlock() {
         return new SquareType[][] {
                { J, EMPTY, EMPTY },
                { J, J, J},
                { EMPTY, EMPTY, EMPTY}
        };
    }

    private static SquareType[][] createLBlock() {
        return new SquareType[][] {
                { EMPTY, EMPTY, EMPTY},
                { L, L, L},
                { L, EMPTY, EMPTY}
        };
    }

    private static SquareType[][] createOBlock() {
        return new SquareType[][] { { O, O }, { O, O } };
        }

    private static SquareType[][] createSBlock() {
        return new SquareType[][] {
                { EMPTY, S, S},
                { S, S, EMPTY},
                { EMPTY, EMPTY, EMPTY}
        };
    }

    private static SquareType[][] createTBlock() {
        return new SquareType[][] {
                { EMPTY, T, EMPTY},
                { T, T, T},
                { EMPTY, EMPTY, EMPTY}
        };
    }

    private static SquareType[][] createZBlock() {
        return new SquareType[][] {
                { Z, Z, EMPTY},
                { EMPTY, Z, Z},
                { EMPTY, EMPTY, EMPTY}
        };
    }

    private static SquareType[][] createEMPTYBlock() {
            return new SquareType[][]{
                { EMPTY, EMPTY, EMPTY, EMPTY},
                { EMPTY, EMPTY, EMPTY, EMPTY },
                { EMPTY, EMPTY, EMPTY, EMPTY},
                { EMPTY, EMPTY, EMPTY, EMPTY},
            };
        }
}