package com.groovycalamari.greachapi

import com.groovycalamari.greachapi.geb.AboutFetcher
import com.groovycalamari.greachapi.geb.HomePage
import geb.Browser
import spock.lang.Specification

class AboutFetcherSpec extends Specification {

    def "test address is fetched correctly"() {
        when:
        def browser = new Browser()
        HomePage page = browser.to HomePage
        String address = page.address()

        then:
        address == 'The Greach Network SL, 2011-2017 - CIF B86412491 - C/Valtravieso, 28023 Madrid (Spain)'

        when:
        def email = page.email()

        then:
        email == 'crew@greachconf.com'

        when:
        def youtube = page.youtube()

        then:
        youtube == 'http://www.youtube.com/user/TheGreachChannel'

        when:
        def about = AboutFetcher.fetchAbout()

        then:
        about.email == 'crew@greachconf.com'
        about.youtube == 'http://www.youtube.com/user/TheGreachChannel'
        about.address == 'The Greach Network SL, 2011-2017 - CIF B86412491 - C/Valtravieso, 28023 Madrid (Spain)'
        !about.crew.isEmpty()
    }

}
