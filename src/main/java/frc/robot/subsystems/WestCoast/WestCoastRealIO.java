// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.WestCoast;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;

public class WestCoastRealIO implements WestCoastIO {
  private final CANSparkMax primaryLeftMotor;
  private final CANSparkMax primaryRightMotor;
  private final CANSparkMax secondaryLeftMotor;
  private final CANSparkMax secondaryRightMotor;

  private final RelativeEncoder primaryLeftRelativeEncoder;
  private final RelativeEncoder primaryRightRelativeEncoder;
  private final RelativeEncoder secondaryLeftRelativeEncoder;
  private final RelativeEncoder secondaryRightRelativeEncoder;

  /** Creates a new WestCoastIO. */
  public WestCoastRealIO(int primaryLeftPort, int primaryRightPort, int secondaryLeftPort, int secondaryRightPort) {
    primaryLeftMotor = new CANSparkMax(primaryLeftPort, MotorType.kBrushless);
    primaryRightMotor = new CANSparkMax(primaryRightPort, MotorType.kBrushless);
    secondaryLeftMotor = new CANSparkMax(secondaryLeftPort, MotorType.kBrushless);
    secondaryRightMotor = new CANSparkMax(secondaryRightPort, MotorType.kBrushless);

    secondaryLeftMotor.follow(primaryLeftMotor);
    secondaryRightMotor.follow(primaryRightMotor);

    primaryLeftRelativeEncoder = primaryLeftMotor.getEncoder();
    primaryRightRelativeEncoder = primaryRightMotor.getEncoder();
    secondaryLeftRelativeEncoder = secondaryLeftMotor.getEncoder();
    secondaryRightRelativeEncoder = secondaryRightMotor.getEncoder();

    primaryLeftRelativeEncoder.setPositionConversionFactor(Constants.DRIVE_ROTATIONS_TO_DISTANCE);
    primaryRightRelativeEncoder.setPositionConversionFactor(Constants.DRIVE_ROTATIONS_TO_DISTANCE);
    secondaryLeftRelativeEncoder.setPositionConversionFactor(Constants.DRIVE_ROTATIONS_TO_DISTANCE);
    secondaryRightRelativeEncoder.setPositionConversionFactor(Constants.DRIVE_ROTATIONS_TO_DISTANCE);
  }

  public WestCoastRealIO get() {
    return this;
  }
}
