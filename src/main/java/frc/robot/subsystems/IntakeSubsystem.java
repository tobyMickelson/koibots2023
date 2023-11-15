// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

    private static CANSparkMax intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(Constants.Motors.INTAKE_MOTOR, MotorType.kBrushless);
    }

    // GETTERS

    public static IntakeSubsystem get() {
        return intakeSubsystem;
    }

    // SETTERS

    public void setIntakeMotor(double speed) {
        intakeMotor.set(-speed);
    }

    // COMMANDS

    public class RunIntakeCommand extends CommandBase {
        private double speed;

        public RunIntakeCommand(double speed) {
            this.speed = speed;
            addRequirements(IntakeSubsystem.this);
        }

        public RunIntakeCommand() {
            this.speed = Constants.Motors.INTAKE_SPEED;
            addRequirements(IntakeSubsystem.this);
        }

        @Override
        public void initialize() {
            IntakeSubsystem.this.setIntakeMotor(speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            IntakeSubsystem.this.setIntakeMotor(0);
        }
    }

    public class RunReverseIntakeCommand extends CommandBase {
        private double speed;

        public RunReverseIntakeCommand(double speed) {
            this.speed = speed;
            addRequirements(IntakeSubsystem.this);
        }

        public RunReverseIntakeCommand() {
            this.speed = Constants.Motors.INTAKE_REVERSE_SPEED;
            addRequirements(IntakeSubsystem.this);
        }

        @Override
        public void initialize() {
            IntakeSubsystem.this.setIntakeMotor(-speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            IntakeSubsystem.this.setIntakeMotor(0);
        }
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
