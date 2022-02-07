package es.infantaelena;

import static es.infantaelena.TresEnRaya.*;
;

public class TestTableros {
	
	static final char [][][] TABLEROS_HORIZONTAL_JUG1 = {
			{{JUG_1,JUG_1,JUG_1},
			{VACIA,VACIA,VACIA},
			{VACIA,VACIA,VACIA}
			},
			{{VACIA,VACIA,VACIA},
			{JUG_1,JUG_1,JUG_1},
			{VACIA,VACIA,VACIA}
			},
			{{VACIA,VACIA,VACIA},
			{VACIA,VACIA,VACIA},
			{JUG_1,JUG_1,JUG_1}
			}};
	static final char [][][] TABLEROS_HORIZONTAL_JUG2 =
		{	{{JUG_2,JUG_2,JUG_2},
			{VACIA,VACIA,VACIA},
			{VACIA,VACIA,VACIA}
			},
			{{VACIA,VACIA,VACIA},
			{JUG_2,JUG_2,JUG_2},
			{VACIA,VACIA,VACIA}
			},
			{{VACIA,VACIA,VACIA},
			{VACIA,VACIA,VACIA},
			{JUG_2,JUG_2,JUG_2}
			}
			};
	
	static final char [][][] TABLEROS_VERTICAL_JUG1  = {
			{{JUG_1,VACIA,VACIA},
			{JUG_1,VACIA,VACIA},
			{JUG_1,VACIA,VACIA}
			},
			{{VACIA,JUG_1,VACIA},
			{VACIA,JUG_1,VACIA},
			{VACIA,JUG_1,VACIA}
			},
			{{VACIA,VACIA,JUG_1},
			{VACIA,VACIA,JUG_1},
			{VACIA,VACIA,JUG_1}
			}};
	
	static final char [][][] TABLEROS_VERTICAL_JUG2  = {
			{{JUG_2,VACIA,VACIA},
			{JUG_2,VACIA,VACIA},
			{JUG_2,VACIA,VACIA}
			},
			{{VACIA,JUG_2,VACIA},
			{VACIA,JUG_2,VACIA},
			{VACIA,JUG_2,VACIA}
			},
			{{VACIA,VACIA,JUG_2},
			{VACIA,VACIA,JUG_2},
			{VACIA,VACIA,JUG_2}
			}
			};
	
	static final char [][][] TABLEROS_DIAGONAL_JUG1 = {
			{{JUG_1,VACIA,VACIA},
			{VACIA,JUG_1,VACIA},
			{VACIA,VACIA,JUG_1}
			},
			{{VACIA,VACIA,JUG_1},
			{VACIA,JUG_1,VACIA},
			{JUG_1,VACIA,VACIA}
			}};
	
	static final char [][][] TABLEROS_DIAGONAL_JUG2 = {	
			{{JUG_2,VACIA,VACIA},
			{VACIA,JUG_2,VACIA},
			{VACIA,VACIA,JUG_2}
			},
			{{VACIA,VACIA,JUG_2},
			{VACIA,JUG_2,VACIA},
			{JUG_2,VACIA,VACIA}
			}
			};

	static final char [][][] TABLEROS_EMPATE = {
			{{JUG_2,JUG_1,JUG_1},
			{JUG_1,JUG_1,JUG_2},
			{JUG_2,JUG_2,JUG_1}
			},
			{{JUG_1,JUG_2,JUG_1},
			{JUG_1,JUG_2,JUG_2},
			{JUG_2,JUG_1,JUG_1}
			},
			{{JUG_1,JUG_1,JUG_2},
			{JUG_2,JUG_1,JUG_1},
			{JUG_1,JUG_2,JUG_2}
			},
			{{JUG_2,JUG_1,JUG_2},
			{JUG_1,JUG_1,JUG_2},
			{JUG_2,JUG_2,JUG_1}
			}
			};
	
	static final char [][][] TABLEROS_SIN_TERMINAR = {
			{{JUG_2,JUG_1,JUG_1},
			{JUG_1,JUG_1,JUG_2},
			{JUG_2,JUG_2,VACIA}
			},
			{{VACIA,JUG_2,JUG_1},
			{JUG_1,JUG_2,JUG_2},
			{JUG_2,JUG_1,JUG_1}
			},
			{{JUG_1,JUG_1,JUG_2},
			{JUG_2,JUG_1,VACIA},
			{JUG_1,JUG_2,JUG_2}
			},
			{{JUG_2,JUG_1,JUG_2},
			{JUG_1,VACIA,JUG_2},
			{JUG_2,JUG_2,JUG_1}
			}
			};

}
