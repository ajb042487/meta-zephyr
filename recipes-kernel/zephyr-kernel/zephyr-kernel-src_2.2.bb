
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

# tag v2.2
SRCREV="d39cb42d0920d5658fad358ad5b91de75d747a20"
SRC_URI = "git://github.com/zephyrproject-rtos/zephyr.git;protocol=https;branch=v2.2-branch \
          file://0001-cmake-add-yocto-toolchain.patch \
        "
inherit cmake 
PV = "2.2.0"
S = "${WORKDIR}/git"

IMAGE_NO_MANIFEST = "1"
INHIBIT_DEFAULT_DEPS = "1"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_compile () {
}

do_install () {
    kerneldir=${D}/usr/src/zephyr
    install -d $kerneldir
    cp -r ${S}/* $kerneldir
}

PACKAGES = "${PN}"
FILES_${PN} = "/usr/src/zephyr"

SYSROOT_DIRS += "/usr/src/zephyr"

