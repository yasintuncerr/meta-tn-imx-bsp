SUMMARY = "Minimal Camera and VPU OS Image"
LICENSE = "MIT"

inherit core-image

#System Base
IMAGE_INSTALL += " \
    packagegroup-core-boot \
    dropbear \
    nano \
    htop \
"

# VPU (Hantro) and Multimedia (GStreamer, V4L2)
IMAGE_INSTALL += " \
    imx-vpu-hantro \
    firmware-imx-vpu-imx8mp \
    v4l-utils \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"

# Wi-Fi (NXP 8997 PCIe), Hotspot and Network
IMAGE_INSTALL += " \
    linux-firmware-pcie8997 \
    kernel-module-mwifiex-pcie \
    wpa-supplicant \
    hostapd \
    iw \
    iproute2 \
"

# Camera Kernel Modules and TechNexion Drivers
IMAGE_INSTALL += " \
    kernel-modules \
"

# Debian Package Manager Support
PACKAGE_CLASSES = "package_deb"
IMAGE_FEATURES += "package-management"

# Desktop/Interface packages
IMAGE_FEATURES:remove = "x11-base x11-sato wayland"

IMAGE_INSTALL:remove = " \
    tn-apt-list \
    vizionsdk-dev \
    vizionviewer \
    packagegroup-tn-tools \
    packagegroup-tn-vizionsdk \
    packagegroup-tn-wlan \
    get-support-info \
    glmark2 \
"