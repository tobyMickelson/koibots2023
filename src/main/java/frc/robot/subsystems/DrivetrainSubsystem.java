// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import frc.robot.Constants;

import java.util.function.DoubleSupplier;

public class DrivetrainSubsystem extends SubsystemBase {
    private static DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
    private static boolean slowMode = false;
    private DoubleSupplier speedMultiplier = () -> Constants.Motors.DRIVE_SPEED_COEFFICIENT;

    private static CANSparkMax primaryLeftMotor;
    private static CANSparkMax primaryRightMotor;
    // private static CANSparkMax secondaryLeftMotor;
    // private static CANSparkMax secondaryRightMotor;

    /*
    private static RelativeEncoder primaryLeftEncoder;
    private static RelativeEncoder primaryRightEncoder;
    private static RelativeEncoder secondaryLeftEncoder;
    private static RelativeEncoder secondaryRightEncoder;
    */

    public DrivetrainSubsystem() {
        primaryLeftMotor = new CANSparkMax(Constants.Motors.PRIMARY_LEFT_DRIVE, MotorType.kBrushless);
        primaryRightMotor = new CANSparkMax(Constants.Motors.PRIMARY_RIGHT_DRIVE, MotorType.kBrushless);
        // secondaryLeftMotor = new CANSparkMax(Constants.Motors.SECONDARY_LEFT_DRIVE, MotorType.kBrushless);
        // secondaryRightMotor = new CANSparkMax(Constants.Motors.SECONDARY_RIGHT_DRIVE, MotorType.kBrushless);

        primaryLeftMotor.setInverted(Constants.Motors.INVERT_LEFT_DRIVE);
        primaryRightMotor.setInverted(Constants.Motors.INVERT_RIGHT_DRIVE);
        // secondaryLeftMotor.follow(primaryLeftMotor);
        // secondaryRightMotor.follow(primaryRightMotor);

        /*
        primaryLeftEncoder = primaryLeftMotor.getEncoder();
        primaryRightEncoder = primaryRightMotor.getEncoder();
        secondaryLeftEncoder = secondaryLeftMotor.getEncoder();
        secondaryRightEncoder = secondaryRightMotor.getEncoder();

        primaryLeftEncoder.setPositionConversionFactor(Constants.Motors.ROTATION_TO_DISTANCE);
        primaryRightEncoder.setPositionConversionFactor(Constants.Motors.ROTATION_TO_DISTANCE);
        secondaryLeftEncoder.setPositionConversionFactor(Constants.Motors.ROTATION_TO_DISTANCE);
        secondaryRightEncoder.setPositionConversionFactor(Constants.Motors.ROTATION_TO_DISTANCE);
        */
    }

    // GETTERS

    public static DrivetrainSubsystem get() {
        return drivetrainSubsystem;
    }

    // SETTERS

    public void setMotors(double leftSpeed, double rightSpeed) {
        primaryLeftMotor.set(leftSpeed);
        primaryRightMotor.set(rightSpeed);
    }

    // COMMANDS

    public class TeleopCommand extends CommandBase {
        private DoubleSupplier leftSpeed;
        private DoubleSupplier rightSpeed;

        public TeleopCommand(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
            this.leftSpeed = leftSpeed;
            this.rightSpeed = rightSpeed;
            addRequirements(DrivetrainSubsystem.this);
        }

        private double deadzone(double in) {
            if (in > Constants.Controls.DRIVE_DEADZONE || in < -Constants.Controls.DRIVE_DEADZONE) {return in;}
            else {return 0.0;}
        }

        @Override
        public void initialize() {

        }

        @Override
        public void execute() {
            DrivetrainSubsystem.this.setMotors(
                deadzone(leftSpeed.getAsDouble()) * speedMultiplier.getAsDouble(),
                deadzone(rightSpeed.getAsDouble()) * speedMultiplier.getAsDouble()
            );
        }
    }

    public class SlowModeCommand extends CommandBase {
        public SlowModeCommand(boolean enableSlowMode) {
            slowMode = enableSlowMode;
            if (slowMode) {
                speedMultiplier = () -> Constants.Motors.DRIVE_SLOW_SPEED_COEFFICIENT;
            } else {
                speedMultiplier = () -> Constants.Motors.DRIVE_SPEED_COEFFICIENT;
            }
        }

        public SlowModeCommand() {
            slowMode = !slowMode;
            if (slowMode) {
                speedMultiplier = () -> Constants.Motors.DRIVE_SLOW_SPEED_COEFFICIENT;
            } else {
                speedMultiplier = () -> Constants.Motors.DRIVE_SPEED_COEFFICIENT;
            }
        }
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
