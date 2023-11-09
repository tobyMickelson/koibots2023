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

    private CANSparkMax primaryLeftMotor;
    private CANSparkMax primaryRightMotor;
    private CANSparkMax secondaryLeftMotor;
    private CANSparkMax secondaryRightMotor;

    /*
    private RelativeEncoder primaryLeftEncoder;
    private RelativeEncoder primaryRightEncoder;
    private RelativeEncoder secondaryLeftEncoder;
    private RelativeEncoder secondaryRightEncoder;
    */



    private double speedCoefficient = Constants.Motors.SPEED_COEFFICIENT;

    public DrivetrainSubsystem() {
        primaryLeftMotor = new CANSparkMax(Constants.Motors.PRIMARY_LEFT_DRIVE, MotorType.kBrushless);
        primaryRightMotor = new CANSparkMax(Constants.Motors.PRIMARY_RIGHT_DRIVE, MotorType.kBrushless);
        secondaryLeftMotor = new CANSparkMax(Constants.Motors.SECONDARY_LEFT_DRIVE, MotorType.kBrushless);
        secondaryRightMotor = new CANSparkMax(Constants.Motors.SECONDARY_RIGHT_DRIVE, MotorType.kBrushless);

        primaryLeftMotor.setInverted(Constants.Motors.INVERT_LEFT);
        primaryRightMotor.setInverted(Constants.Motors.INVERT_RIGHT);
        secondaryLeftMotor.follow(primaryLeftMotor);
        secondaryRightMotor.follow(primaryRightMotor);

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

    public class teleopCommand extends CommandBase {
        private DoubleSupplier leftSpeed;
        private DoubleSupplier rightSpeed;

        public teleopCommand(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
            this.leftSpeed = leftSpeed;
            this.rightSpeed = rightSpeed;
            addRequirements(DrivetrainSubsystem.this);
        }

        @Override
        public void initialize() {

        }

        @Override
        public void execute() {
            DrivetrainSubsystem.this.setMotors(
                deadzone(leftSpeed.getAsDouble()) * speedCoefficient,
                deadzone(leftSpeed.getAsDouble()) * speedCoefficient
            );
        }

        private double deadzone(double in) {
            return in;
        }
    }

    public CommandBase exampleMethodCommand() {
        // Inline construction of command goes here.
        // Subsystem::RunOnce implicitly requires `this` subsystem.
        return runOnce(
                () -> {
                    /* one-time action goes here */
                });
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
