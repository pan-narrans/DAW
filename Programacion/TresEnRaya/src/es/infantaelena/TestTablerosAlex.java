package es.infantaelena;

import static es.infantaelena.TresEnRaya.*;;

public class TestTablerosAlex {
  static final char[][][] TABLEROS_HORIZONTAL_DOS_SEGUIDAS = {
      { { VACIA, JUG_1, JUG_1 },
          { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { JUG_1, VACIA, JUG_1 },
          { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { JUG_1, JUG_1, VACIA },
          { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, JUG_1 },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { JUG_1, VACIA, JUG_1 },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { JUG_1, JUG_1, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, JUG_1 }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA },
          { JUG_1, VACIA, JUG_1 }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, VACIA, VACIA },
          { JUG_1, JUG_1, VACIA }
      } };

  static final char[][][] TABLEROS_VERTICAL_DOS_SEGUIDAS = {
      { { VACIA, VACIA, VACIA },
          { JUG_1, VACIA, VACIA },
          { JUG_1, VACIA, VACIA }
      },
      { { JUG_1, VACIA, VACIA },
          { VACIA, VACIA, VACIA },
          { JUG_1, VACIA, VACIA }
      },
      { { JUG_1, VACIA, VACIA },
          { JUG_1, VACIA, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, VACIA },
          { VACIA, JUG_1, VACIA }
      },
      { { VACIA, JUG_1, VACIA },
          { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, VACIA }
      },
      { { VACIA, JUG_1, VACIA },
          { VACIA, JUG_1, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, VACIA, JUG_1 },
          { VACIA, VACIA, JUG_1 }
      },
      { { VACIA, VACIA, JUG_1 },
          { VACIA, VACIA, VACIA },
          { VACIA, VACIA, JUG_1 }
      },
      { { VACIA, VACIA, JUG_1 },
          { VACIA, VACIA, JUG_1 },
          { VACIA, VACIA, VACIA } }
  };
  static final char[][][] TABLEROS_DIAGONAL_DOS_SEGUIDAS = {
      { { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, VACIA },
          { VACIA, VACIA, JUG_1 }
      },
      { { JUG_1, VACIA, VACIA },
          { VACIA, VACIA, VACIA },
          { VACIA, VACIA, JUG_1 }
      },
      { { JUG_1, VACIA, VACIA },
          { VACIA, JUG_1, VACIA },
          { VACIA, VACIA, VACIA }
      },
      { { VACIA, VACIA, VACIA },
          { VACIA, JUG_1, VACIA },
          { JUG_1, VACIA, VACIA }
      },
      { { VACIA, VACIA, JUG_1 },
          { VACIA, VACIA, VACIA },
          { JUG_1, VACIA, VACIA }
      },
      { { VACIA, VACIA, JUG_1 },
          { VACIA, JUG_1, VACIA },
          { VACIA, VACIA, VACIA }
      }
  };
}
