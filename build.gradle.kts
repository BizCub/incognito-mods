plugins {
    id("io.github.bizcub.multiloader")
}

multiloader {
    addSourceSet("testmod")

    setMREnvironment(mrEnvs.clientOnly)
    setCFEnvironment(cfEnvs.client)

    addDependency(
        dependency = getSimpleConfigLibDep(),
        configuration = "compileOnly",
        isPublishDepEnabled = true
    )

    if (isFabric) {
        addDependency(
            dependency = "net.fabricmc:fabric-loader:${getDep("fabric")}"
        )
        addDependency(
            dependency = "com.terraformersmc:modmenu:${getDep("modmenu")}",
            repository = "maven.terraformersmc.com/releases",
            configuration = "compileOnly"
        )
    }
}
