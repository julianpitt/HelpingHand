@include('common.header')

    {{--Top nav--}}
    <header>
    </header>

    <main>

        @include('flash::message')

        @yield('content')

        @include('common.footer')

    </main>