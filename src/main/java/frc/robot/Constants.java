// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final double DRIVE_ROTATIONS_TO_DISTANCE = 0.04873967373;
  public static final double OUTPUT_OVER_INPUT_TORQUE = 1768/165;
  public static final double TRACK_WIDTH = Units.inchesToMeters(21);
  public static final double WHEEL_RADIUS = Units.inchesToMeters(2.7815);
  public static final double ROBOT_WEIGHT_KG = Units.lbsToKilograms(72);
  public static final double ROBOT_MOMENT_OF_INERTIA = (ROBOT_WEIGHT_KG/6) * 1008.0625;

  public static final int PRIMARY_RIGHT_MOTOR_PORT = 12;
  public static final int SECONDARY_RIGHT_MOTOR_PORT = 13;
  public static final int PRIMARY_LEFT_MOTOR_PORT = 15;
  public static final int SECONDARY_LEFT_MOTOR_PORT = 14;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kOperatorControllerPort = 1;
  }
  public static class SimConstants {

  }
}
