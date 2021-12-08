
public class ArrayIntList {

	private int[] elementData;
	private int size;

	public ArrayIntList() {

	}

	public ArrayIntList(int[] elementData, int size) {
		this.elementData = elementData;
		size = elementData.length;
	}

	public int[] getElementData() {
		return elementData;
	}

	public void setElementData(int[] elementData) {
		this.elementData = elementData;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void fromCount() {
		int size = 0;
		for (int i = 0; i < this.elementData.length; i += 2) {
			size += elementData[i];
		}
		int[] arr = new int[size];

		int i = 0, j = 1, pos = 0;
		while (pos < size) {
			int count = 1;
			while (count <= elementData[i]) {
				arr[pos] = elementData[j];
				System.out.print(arr[pos] + ";");
				pos++;
				count++;

			}
			System.out.print("=\n");
			i += 2;
			j += 2;

		}
	}

	public void display() {
		for (int i = 0; i < elementData.length; i++) {
			System.out.print(elementData[i] + " ");
		}
	}
}