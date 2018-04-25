package sorting_algorithms;

public class ShearSort extends Sort{

	public static void shearSort(int a[]) throws Exception{
		int Log, Rows, Cols;
		int pow = 1, div = 1;
		int h[];

		for(int i = 1; i * i <= a.length; i++){
			if(a.length % i == 0){
				div = i;
			}
		}
		Rows = div;
		Cols = a.length / div;
		for(Log = 0; pow <= Rows; Log++){
			pow = pow * 2;
		}

		h = new int[Rows];
		for(int i = 0; i < Rows; i++){
			h[i] = i * Cols;
		}

		for(int k = 0; k < Log; k++){
			for(int j = 0; j < Cols / 2; j++){
				for(int i = 0; i < Rows; i++){
					sortPart1(a, i * Cols, (i + 1) * Cols, 1, (i % 2 == 0 ? true : false));
				}

				for(int i = 0; i < Rows; i++){
					sortPart2(a, i * Cols, (i + 1) * Cols, 1, (i % 2 == 0 ? true : false));
				}

			}
			for(int j = 0; j < Rows / 2; j++){
				for(int i = 0; i < Cols; i++){
					sortPart1(a, i, Rows * Cols + i, Cols, true);
				}

				for(int i = 0; i < Cols; i++){
					sortPart2(a, i, Rows * Cols + i, Cols, true);
				}

			}
		}
		for(int j = 0; j < Cols / 2; j++){
			for(int i = 0; i < Rows; i++){
				sortPart1(a, i * Cols, (i + 1) * Cols, 1, true);
			}

			for(int i = 0; i < Rows; i++){
				sortPart2(a, i * Cols, (i + 1) * Cols, 1, true);
			}

		}
		for(int i = 0; i < Rows; i++){
			h[i] = -1;
		}

	}

	private static void sortPart1(int a[], int Lo, int Hi, int Nx, boolean Up) throws Exception{
		for(int j = Lo; j + Nx < Hi; j += 2 * Nx){
			if((Up && a[j] > a[j + Nx]) || !Up && a[j] < a[j + Nx]){
				int T = a[j];
				a[j] = a[j + Nx];
				a[j + Nx] = T;
			}
		}
	}

	private static void sortPart2(int a[], int Lo, int Hi, int Nx, boolean Up) throws Exception{
		for(int j = Lo + Nx; j + Nx < Hi; j += 2 * Nx){
			if((Up && a[j] > a[j + Nx]) || !Up && a[j] < a[j + Nx]){
				int T = a[j];
				a[j] = a[j + Nx];
				a[j + Nx] = T;
			}
		}
	}
}
