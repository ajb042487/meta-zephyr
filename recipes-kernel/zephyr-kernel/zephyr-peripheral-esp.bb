require zephyr-kernel.inc
require zephyr-kernel-common.inc
inherit deploy

ZEPHYR_SAMPLE_NAME="samples/bluetooth/peripheral_esp"
ZEPHYR_SRC_DIR = "${S}/${ZEPHYR_SAMPLE_NAME}"
ZEPHYR_BASE = "${S}"

do_compile () {
    cd ${ZEPHYR_SRC_DIR}
    oe_runmake ${ZEPHYR_MAKE_ARGS}
}

do_deploy () {
    install -D ${ZEPHYR_SAMPLE_NAME}/outdir/${BOARD}/zephyr.elf ${DEPLOYDIR}/${PN}.elf
    install -D ${ZEPHYR_SAMPLE_NAME}/outdir/${BOARD}/zephyr.bin ${DEPLOYDIR}/${PN}.bin
}

addtask deploy after do_compile
