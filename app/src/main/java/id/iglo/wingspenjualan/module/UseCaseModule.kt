package id.iglo.wingspenjualan.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import id.iglo.api_service.usecase.ProductUseCase

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {
    @Provides
    fun provideProductUseCase() =
        ProductUseCase()
}