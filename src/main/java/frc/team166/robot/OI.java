/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.team166.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import frc.team166.chopshoplib.controls.ButtonJoystick;
import frc.team166.chopshoplib.controls.ButtonXboxController;
import frc.team166.robot.subsystems.Manipulator;;

public class OI {
    // Creates joysticks
    public ButtonJoystick leftDriveStick;
    public ButtonJoystick rightDriveStick;
    public ButtonXboxController xBoxTempest;
    public ButtonXboxController xBoxDrive;

    public OI() {
        // defines the joysticks as joysticks and assigns left and right
        leftDriveStick = new ButtonJoystick(RobotMap.Controller.leftcontrol);
        rightDriveStick = new ButtonJoystick(RobotMap.Controller.rightcontrol);
        xBoxTempest = new ButtonXboxController(RobotMap.Controller.Xboxcontrol);
        xBoxDrive = new ButtonXboxController(RobotMap.Controller.xboxDrive);

        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kY.get())
                .whenPressed(Robot.manipulator.CloseOuterManipulator());
        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kX.get())
                .whenPressed(Robot.manipulator.OpenOuterManipulator());

        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kA.get())
                .whileHeld(Robot.manipulator.ManipulatorIntakeHeld());
        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kB.get())
                .whileHeld(Robot.manipulator.ManipulatorDischargeHeld());

        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kBumperLeft.get())
                .whileHeld(Robot.manipulator.ManipulatorIntakeHeld());
        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kBumperRight.get())
                .whileHeld(Robot.manipulator.ManipulatorDischargeHeld());

        xBoxTempest.getButton(ButtonXboxController.xBoxButton.kStickRight.get()).whenPressed(Robot.DriverSwitch());
        // lift.DeployManipulatorForSwitch()).then(manipulator.ManipulatorDischarge()

        rightDriveStick.getButton(2).whenPressed(Robot.manipulator.CubeClamp());
        rightDriveStick.getButton(1).whenPressed(Robot.manipulator.CubeDrop());

    }
}
