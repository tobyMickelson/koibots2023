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
        // SPEEDS
        public static final double DRIVE_SPEED_COEFFICIENT = 0.4;
        public static final double DRIVE_SLOW_SPEED_COEFFICIENT = 0.2;
        public static final double INTAKE_SPEED = 0.5;
        public static final double INTAKE_REVERSE_SPEED = 0.5;
        public static final double MIDTAKE_SPEED = 0.5;
        public static final double MIDTAKE_REVERSE_SPEED = 0.25;
        public static final double FAST_SHOOTER_SPEED = 0.6;
        public static final double SLOW_SHOOTER_SPEED = 0.3;
        public static final double SHOOTER_REVERSE_SPEED = 0.25;
        public static final boolean INVERT_LEFT_DRIVE = false;
        public static final boolean INVERT_RIGHT_DRIVE = true;
        public static final boolean INVERT_LEFT_SHOOTER = true;
        public static final boolean INVERT_RIGHT_SHOOTER = false;
        public static final double ROTATION_TO_DISTANCE = 0.04873967373;

        // CAN IDs
        public static final int PRIMARY_LEFT_DRIVE = 14;
        public static final int PRIMARY_RIGHT_DRIVE = 12;
        public static final int SECONDARY_LEFT_DRIVE = 15;
        public static final int SECONDARY_RIGHT_DRIVE = 13;
        public static final int INTAKE_MOTOR = 10;
        public static final int MIDTAKE_MOTOR = 4;
        public static final int LEFT_SHOOTER_MOTOR = 5;
        public static final int RIGHT_SHOOTER_MOTOR = 8;
    }
    public static class Controls {
        public static final int DRIVER_PORT = 0;
        public static final int LEFT_DRIVE_AXIS = 1;
        public static final int RIGHT_DRIVE_AXIS = 3;
        public static final double DRIVE_DEADZONE = 0.1;
        public static final double TRIGGER_DEADZONE = 0.5;
    }
}
