// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class Motors {
        public static final double SPEED_COEFFICIENT = 0.25;
        public static final double ROTATION_TO_DISTANCE = 0.04873967373;
        public static final boolean INVERT_LEFT = true;
        public static final boolean INVERT_RIGHT = false;
        public static final int PRIMARY_LEFT_DRIVE = 15;
        public static final int PRIMARY_RIGHT_DRIVE = 12;
        public static final int SECONDARY_LEFT_DRIVE = 14;
        public static final int SECONDARY_RIGHT_DRIVE = 13;
    }
    public static class Controls {
        public static final int DRIVER_PORT = 0;
        public static final int LEFT_DRIVE_AXIS = 1;
        public static final int RIGHT_DRIVE_AXIS = 3;
    }
}
