package org.grails

import io.micronaut.context.ApplicationContext
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class LatestVersionSpec extends Specification {

    @Shared
    @AutoCleanup
    ApplicationContext context = ApplicationContext.run()

    @Shared
    BintrayClient client = context.getBean(BintrayClient)


    @Unroll
    def "#packagename latest version released to bintray/jcenter matches #gormVersion"() {

        when:
        BintrayPackageVersion packageVersion = client.latestVersion("org.grails:$packagename".toString())

        then:
        packageVersion
        packageVersion.name == gormVersion

        where:
        gormVersion = '6.1.10.RELEASE'
        packagename << ['grails-datastore-gorm-hibernate-core',
                        'grails-datastore-async',
                        'grails-datastore-core',
                        'grails-datastore-gorm-async',
                        'grails-datastore-gorm-grails2-support',
                        'grails-datastore-gorm-grails2-test',
                        'grails-datastore-gorm-hibernate-core',
                        'grails-datastore-gorm-plugin-support',
                        'grails-datastore-gorm-rx-plugin-support',
                        'grails-datastore-gorm-rx',
                        'grails-datastore-gorm-support',
                        'grails-datastore-gorm-tck',
                        'grails-datastore-gorm-test',
                        'grails-datastore-gorm-validation',
                        'grails-datastore-gorm',
                        'grails-datastore-gorm-hibernate5',
        ]
    }

}
