FILESEXTRAPATHS:prepend := "${THISDIR}/file:"



do_patch:append() {
    sed -i 's/size = <0 0x3c000000>;/size = <0 0x20000000>;/' ${S}/arch/arm64/boot/dts/freescale/imx8mp.dtsi
    sed -i 's/alloc-ranges = <0 0x40000000 0 0x40000000>;/alloc-ranges = <0 0x40000000 0 0xC0000000>;/' ${S}/arch/arm64/boot/dts/freescale/imx8mp.dtsi
}

SRC_URI:append:tn-camera = " \
       file://tn-camera.cfg \
       "
SRCBRANCH:tn-camera = "tn-imx_6.12.49_2.2.0-next"
LINUX_IMX_SRC:tn-camera = "git://github.com/TechNexion/linux-tn-imx.git;protocol=https;nobranch=1;branch=${SRCBRANCH}"
SRCREV:tn-camera = "c2aeaa26480f1939e6d8ff44436345649ac05a17"
DELTA_KERNEL_DEFCONFIG:tn-camera = "tn-camera.cfg"
