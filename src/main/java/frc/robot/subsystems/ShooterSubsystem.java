// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
    private static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    private static CANSparkMax leftShooterMotor;
    private static CANSparkMax rightShooterMotor;

    public ShooterSubsystem() {
        leftShooterMotor = new CANSparkMax(Constants.Motors.LEFT_SHOOTER_MOTOR, MotorType.kBrushless);
        rightShooterMotor = new CANSparkMax(Constants.Motors.RIGHT_SHOOTER_MOTOR, MotorType.kBrushless);

        leftShooterMotor.setInverted(Constants.Motors.INVERT_LEFT_SHOOTER);
        rightShooterMotor.setInverted(Constants.Motors.INVERT_RIGHT_SHOOTER);
    }

    // GETTERS

    public static ShooterSubsystem get() {
        return shooterSubsystem;
    }

    // SETTERS

    public void setShooterMotors(double speed) {
        leftShooterMotor.set(speed);
        rightShooterMotor.set(speed);
    }

    // COMMANDS

    public class RunShooterCommand extends CommandBase {
        private double speed;

        public RunShooterCommand(double speed) {
            this.speed = speed;
            addRequirements(ShooterSubsystem.this);
        }

        public RunShooterCommand() {
            this.speed = Constants.Motors.FAST_SHOOTER_SPEED;
            addRequirements(ShooterSubsystem.this);
        }

        @Override
        public void initialize() {
            ShooterSubsystem.this.setShooterMotors(speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            ShooterSubsystem.this.setShooterMotors(0);
        }
    }

    public class RunReverseShooterCommand extends CommandBase {
        private double speed;

        public RunReverseShooterCommand(double speed) {
            this.speed = speed;
            addRequirements(ShooterSubsystem.this);
        }

        public RunReverseShooterCommand() {
            this.speed = Constants.Motors.SHOOTER_REVERSE_SPEED;
            addRequirements(ShooterSubsystem.this);
        }

        @Override
        public void initialize() {
            ShooterSubsystem.this.setShooterMotors(-speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            ShooterSubsystem.this.setShooterMotors(0);
        }
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
