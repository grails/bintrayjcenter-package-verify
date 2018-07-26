package org.grails

import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.Client
import io.reactivex.Flowable
import io.reactivex.Single

@CompileStatic
@Client(BintrayConfiguration.BINTRAY_API_URL)
interface BintrayClient {

    @Get('/api/${bintray.apiversion}/packages/${bintray.organization}/${bintray.repo}/{packagename}/versions/_latest')
    BintrayPackageVersion latestVersion(String packagename) // <3>
}
