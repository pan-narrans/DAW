using Sirenix.OdinInspector;

using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

// https://tips.clip-studio.com/de-de/articles/3567?org=1

namespace UnityEngine.Rendering
{
  public class DayCycle : MonoBehaviour
  {

    // / <summary> / Collection of settings defining a moment in a day: / <list
    // type="bullet"> / <item> SkyBox </item> / <item> Sun Color </item> / <item>
    // Sun Intensity </item> / <item> Sun Shadow's Strength </item> / </list> /
    // </summary>
    [Serializable]
    public struct DaySettings
    {
      [VerticalGroup("Skybox")]
      [TableColumnWidth(57, Resizable = false)]
      [HideLabel]
      [PreviewField(Alignment = ObjectFieldAlignment.Center)]
      public Material skybox;

      [VerticalGroup("Sun")]
      public Color sunColor;

      [VerticalGroup("Sun")]
      public float intensity,
      shadowStrength;
    } // End Struct

    [SerializeField]
    [FoldoutGroup("References")]
    private GameObject sunGameObj;
    [SerializeField]
    [FoldoutGroup("References")]
    private Light sunComp;
    [SerializeField]
    [FoldoutGroup("References")]
    private Material skybox;
    // [SerializeField] [FoldoutGroup("References")] private VolumeProfile
    // URPProfile; / <summary> / List of presets for a given day. / We're using
    // Noon, Night, Dawn & Day. / </summary> / <value></value>
    [Title("Presets")]
    [TableList(ShowIndexLabels = true)]
    public List<DaySettings> DayPresets = new List<DaySettings> { };

    // [Title("Debug")] Array indexes [SerializeField]
    private int currentIndex;
    // [SerializeField]
    private int nextIndex;
    // [SerializeField]
    private int maxIndex;

    // Rotation stuff [SerializeField]
    private float minutesPerDay;
    private readonly float BASE_DAY_DURATION = 1;
    // [SerializeField]
    private float rotationSpeed;
    // [SerializeField]
    private byte pause;

    // Lerp stuff / <summary> / Our current angle progress. / </summary>
    // [SerializeField]
    private float angleMarker;

    /// <summary> / Our current lerp progress. / </summary> [SerializeField]
    private float lerpMarker;

    // / <summary> / Size of the divisions of the circle. / </summary>
    // [SerializeField]
    private float deltaAngle;

    void Awake()
    {
      restartDay();
      minutesPerDay = BASE_DAY_DURATION;
    }

    void Update()
    {

      // MOVEMENT
      rotationSpeed = (pause * 6 * Time.deltaTime) / (minutesPerDay);
      sunGameObj
        .transform
        .Rotate(rotationSpeed, 0f, 0f, Space.Self);

      // LERP CALCULATIONS
      lerpMarker = angleMarker / deltaAngle;
      angleMarker += rotationSpeed;

      if (angleMarker >= deltaAngle)
      {
        angleMarker -= deltaAngle;
        lerpMarker = angleMarker / deltaAngle;
        currentIndex = (currentIndex < maxIndex - 1) ? currentIndex + 1 : 0;
        nextIndex = (currentIndex < maxIndex - 1) ? currentIndex + 1 : 0;
      }

      // COLORS
      sunComp.color = Color.Lerp(
        DayPresets[currentIndex].sunColor,
        DayPresets[nextIndex].sunColor,
        lerpMarker
      );



      sunComp.intensity = Mathf.Lerp(
        DayPresets[currentIndex].intensity,
        DayPresets[nextIndex].intensity,
        lerpMarker
      );
      sunComp.shadowStrength = Mathf.Lerp(
        DayPresets[currentIndex].shadowStrength,
        DayPresets[nextIndex].shadowStrength,
        lerpMarker
      );

      { //  Sun Disc
        // TODO: tratar el sun disk color con el color del SUN
        // skybox.SetColor("_SunDiscColor", Color.Lerp(
        // DayPresets[currentIndex].skybox.GetColor("_SunDiscColor"),
        // DayPresets[nextIndex].skybox.GetColor("_SunDiscColor"), lerpMarker));
        // skybox.SetFloat("_SunDiscMultiplier", Mathf.Lerp(
        // DayPresets[currentIndex].skybox.GetFloat("_SunDiscMultiplier"),
        // DayPresets[nextIndex].skybox.GetFloat("_SunDiscMultiplier"), lerpMarker));
        // skybox.SetFloat("_SunDiscExponent", Mathf.Lerp(
        // DayPresets[currentIndex].skybox.GetFloat("_SunDiscExponent"),
        // DayPresets[nextIndex].skybox.GetFloat("_SunDiscExponent"), lerpMarker));
      }

      // Sun Disc
      //  TODO: tratar el sun disk color con el color del SUN
      setSkyColor("_SunDiscColor");
      setSkyFloat("_SunDiscMultiplier");
      setSkyFloat("_SunDiscExponent");

      // Horizon Line
      setSkyColor("_HorizonLineColor");
      setSkyFloat("_HorizonLineExponent");
      setSkyFloat("_HorizonLineContribution");

      // Sky Gradient
      setSkyColor("_SkyGradientTop");
      setSkyColor("_SkyGradientBottom");
      setSkyFloat("_SkyGradientExponent");
    }
    [Title("Functions")]
    // / <summary> / Sets the amount of real time minutes needed for an inGame day
    // to pass. / </summary> / <param name="minutesPerDay"></param>
    [Button]
    public void setMinutesPerDay(float minutesPerDay)
    {
      this.minutesPerDay = minutesPerDay;
    }

    // / <summary> / Restarts the day to the default morning. <br/> / The day starts
    // unpaused. / </summary>
    [HorizontalGroup("Split", 0.5f)]
    [Button]
    [VerticalGroup("Split/right")]
    public void restartDay()
    {
      // Movement
      sunGameObj.transform.rotation = Quaternion.Euler(0, 30, 0);
      pause = 1;

      // Index
      maxIndex = DayPresets.Count;
      currentIndex = 0;
      nextIndex = currentIndex + 1;

      // Lerp
      lerpMarker = 0.5f;
      angleMarker = 0;
      deltaAngle = 360 / maxIndex;
    }

    /// <summary> / Pauses the day. / </summary>
    [Button]
    [VerticalGroup("Split/right")]
    public void pauseDay()
    {
      pause = 0;
    }

    /// <summary> / Resumes the day. / </summary>
    [Button]
    [VerticalGroup("Split/right")]
    public void resumeDay()
    {
      pause = 1;
    }

    // / <summary> / Sets the hour of the day. <br/> / The hour input is clamped
    // between [0,24]. / </summary> / <param name="hour"></param>
    [Button]
    [VerticalGroup("Split/left")]
    public void setHour(int hour)
    {
      // Assures hour is in the correct range.
      hour = Mathf.Clamp(hour, 0, 24);

      // Calculates the rotation of the sun at said hour
      int angle = Mathf.FloorToInt(hour * (360 / 24) - deltaAngle);
      if (angle < 0)
        angle += 360;

      // Calculates what sky to use
      int index = Mathf.FloorToInt(angle / deltaAngle);

      // Sets everything
      setCurrentIndex(index);
      angleMarker = angle % deltaAngle;
      sunGameObj.transform.rotation = Quaternion.Euler(angle, 50, 0);
    }

    // / <summary> / Sets the current index of the DayPresets Array. <br/> / It
    // automatically clamps the index value to a valid value. / </summary> / <param
    // name="index"></param>
    private void setCurrentIndex(int index)
    {
      // Assures index is in the correct range.
      index = Mathf.Clamp(index, 0, maxIndex - 1);

      currentIndex = index;
      nextIndex = (currentIndex < maxIndex - 1) ? currentIndex + 1 : 0;
    }

    private void setSkyColor(String name)
    {
      skybox.SetColor(name, Color.Lerp(
        DayPresets[currentIndex].skybox.GetColor(name),
        DayPresets[nextIndex].skybox.GetColor(name),
        lerpMarker
      ));
    }

    private void setSkyFloat(String name)
    {
      skybox.SetFloat(name, Mathf.Lerp(
        DayPresets[currentIndex].skybox.GetFloat(name),
        DayPresets[nextIndex].skybox.GetFloat(name),
        lerpMarker
      ));
    }
  }
}