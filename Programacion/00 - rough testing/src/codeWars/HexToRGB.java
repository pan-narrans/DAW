package codeWars;

public class HexToRGB {

  public static int[] hexStringToRGB(String hex) {
    int[] rgb = new int[3];

    for (int i = 1; i < 7; i += 2) {
      rgb[i / 2] = Integer.parseInt(hex.substring(i, i + 2), 16);
    }

    return rgb;
  }

}